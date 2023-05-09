/** 
 * Client code: collects user input and sends it to Quadratic for processing
 * Prints out the results and keeps asking for input until the user enters input to quit
 * @author Jeffrey Ding
 * @version 09/19/22
 */

import java.util.Scanner;

public class QuadraticClient {
	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		String input;
		
		System.out.println("Welcome to the Quadratic Describer");
		
		do {
			System.out.println("\nProvide values for coefficients a, b, and c");
			
			System.out.print("a: ");
			while (!in.hasNextDouble() || in.hasNext("0")) {
				String tempString = in.next();
				System.err.println("\n" + tempString + " is not a valid coefficient");
				System.out.println("Provide a value for coefficient a\n");
			}
			double a = in.nextDouble();
			
			System.out.print("b: ");
			while (!in.hasNextDouble()) {
				String tempString = in.next();
				System.err.println("\n" + tempString + " is not a valid coefficient");
				System.out.println("Provide a value for coefficient b\n");
			}
			double b = in.nextDouble();
			
			System.out.print("c: ");
			while (!in.hasNextDouble()) {
				String tempString = in.next();
				System.err.println("\n" + tempString + " is not a valid coefficient");
				System.out.println("Provide a value for coefficient c\n");
			}
			double c = in.nextDouble();
			
			
			System.out.println(Quadratic.quadrDescriber(a, b, c));
			
			System.out.println("\nDo you want to keep going? (Type \"yes\" to continue or \"quit\" to end)");
			
			while (!in.hasNext("yes") && !in.hasNext("quit")) {
				String tempString = in.next();
				System.err.println("\n" + tempString + " is not a valid option");
				System.out.println("Type \"yes\" to continue or \"quit\" to end\n");
			}
			input = in.next();
			
			if (input.equalsIgnoreCase("quit")) {
				System.out.println("\nBye!");
			}
		} 
		while (input.equalsIgnoreCase("yes"));
		
		in.close();
	}
}
