/**
 * Plays a random number guessing game
 * @author Jeffrey Ding
 * @version 10/01/2022
 */

import java.util.*;

public class Guessing 
{

	public static int getRandomNumber(int low, int high) {
	// generates a random number within the given range, inclusive
		int rand = (int) (Math.random() * (high - low + 1)) + low;
		return rand;
	}
	
	public static String compareToSecret(int guessedNum, int secretNum) {
	// checks if the guess is lower or lower than the secret number
		String guessIs = "";
		if (guessedNum < secretNum)
			guessIs = "low";
		else
			guessIs = "high";
		return guessIs;
	}
	
	public static boolean inRange(int low, int high, int num) {
	// checks if the guess is within the designated range
		if (low <= num && num <= high) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
	// main method
	// plays the game
		Scanner in = new Scanner(System.in);
		
		System.out.println("Welcome. What is your name?");
		String name = in.nextLine();
		System.out.println("\nHello " + name + "!\n");
		
		System.out.println("Enter the lowest value of the guessing range:");
		String temp = in.nextLine();
		int lowest = Integer.parseInt(temp);
		
		System.out.println("Enter the highest value of the guessing range:");
		temp = in.nextLine();
		int highest = Integer.parseInt(temp);
		
		if (highest < lowest) {
			in.close();
			throw new IllegalArgumentException("Upper limit must be greater than lower limit");
		}
		
		int secret = getRandomNumber(lowest, highest);
		
		System.out.println("\nI'm thinking of a number between " + lowest + " and " + highest);
		System.out.println("Guess what my number is!\n");
		
		int guess;
		do {
			while (!in.hasNextInt()) {
				String tempString = in.next();
				System.err.println(tempString + " is not an integer");
				System.out.println("Try guessing an integer between " + lowest + " and " + highest + "\n");
			}
			
			temp = in.nextLine();
			guess = Integer.parseInt(temp);
			if (guess > highest || guess < lowest) {
				in.close();
				throw new IllegalArgumentException(guess + " is outside the valid range");
			}

			if (secret == guess) {
				System.out.println("You guessed right!");
				System.out.println("My number was " + secret + "!");
			}
			else {
				if (guess < lowest) {
					in.close();
					throw new IllegalArgumentException("Invalid guess");
				}
				if (guess > highest) {
					in.close();
					throw new IllegalArgumentException("Invalid guess");
				}
				String lowHigh = compareToSecret(guess, secret);
				System.out.println("Nope. " + guess + " is too " + lowHigh);
				System.out.println("Guess again!\n");
			}
		} while (secret != guess);
			
		in.close();
				
	}

}
