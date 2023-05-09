/**
 * Accepts a size input and prints an hourglass of that size
 * @author Jeffrey Ding
 * @version 10/24/2022
 */

import java.util.*;

public class Hourglass {
	
	public static void main (String[] args) {
	// main method
		Scanner in = new Scanner(System.in);

		System.out.println("What size do you want your hourglass to be?");
		int size = in.nextInt();
		if (size < 1) {
			in.close();
			throw new IllegalArgumentException("The size must be greater than 0.");
		}
		base(size);
		upperBody(size);
		neck(size);
		lowerBody(size);
		base(size);
		in.close();
	}
	
	public static void base(int num) {
	// prints out the base (very top and bottom lines)
		System.out.print("|");
		for(int i = 0; i < num+1; i++) System.out.print("\"\"");
		System.out.println("|");
	}
	
	public static void upperBody(int num) {
	// prints out the upper body of the hourglass
		for(int line = 0; line < num; line++) {
			for(int i = 1; i <= line + 1; i++) System.out.print(" ");
			System.out.print("\\");
			for(int j = line; j < num; j++) System.out.print("::");
			System.out.println("/");
		}
	}
	
	public static void neck(int num) {
	// prints out the neck of the hourglsas
		for(int i = 0; i < num + 1; i++) System.out.print(" ");
		System.out.println("||");
	}
	
	public static void lowerBody(int num) {
	// prints out the lower body of the hourglass
		for(int line = 0; line < num; line++) {
			for(int i = line; i < num; i++) System.out.print(" ");
			System.out.print("/");
			for(int j = 0; j < line + 1; j++) System.out.print("::");
			System.out.println("\\");
		}
	}
}
