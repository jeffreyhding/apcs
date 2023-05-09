/**
 * Accepts a series of numbers as input via the console
 * Prints the smallest and largest numbers input by the user
 * Prints the largest even number and the sum of all even numbers input by the user
 * @author Jeffrey Ding
 * @version 10/12/2022
 */

import java.util.Scanner;

public class ProcessingNumbers {
	public static void main(String[] args) {
	// main method
		Scanner in = new Scanner(System.in);
		// max, min
		// even max, even sum
		System.out.println("How many numbers would you like to enter?");
		int n = in.nextInt();
		
		System.out.println("Enter a number:");
		int input = in.nextInt();
		int max = input;
		int min = input;
		int evenMax = input;
		int evenSum = 0;
		boolean evens = false;
		boolean firstEven = true;
		
		if (input % 2 == 0) {
			evens = true;
			evenMax = input;
			evenSum += input;
			firstEven = false;
		}
		
		for(int i = 0; i < n - 1; i++) {
			System.out.println("Enter a number:");
			input = in.nextInt();
			if (input > max) max = input;
			if (input < min) min = input;
			if (input % 2 == 0) {
				if (firstEven == true) {
					evenMax = input;
					firstEven = false;
				} else {
					if (input > evenMax) evenMax = input;
				}
				evens = true;
				evenSum += input;
			}
		}
		
		System.out.println("The smallest number you entered was " + min + ".");
		System.out.println("The largest number you entered was " + max + ".");
		if (evens == true) {
			System.out.println("The largest even number you entered was " + evenMax + ".");
			System.out.println("The sum of all even numbers you entered was " + evenSum + ".");
		} else System.out.println("You did not enter any even numbers.");
		
		in.close();
	}

}
