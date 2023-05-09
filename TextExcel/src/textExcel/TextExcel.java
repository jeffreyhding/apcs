/** 
 * client code
 * @author Jeffrey Ding
 * @version 02/23/2023
 */ 

package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextExcel {

	public static void main(String[] args) {
	// main method: accepts commands and prints output until user enters "quit"s
		Scanner in = new Scanner(System.in);
		boolean on = true;
		Spreadsheet sheet = new Spreadsheet();
        
		while (on) {
			String input = in.nextLine();
			System.out.println(sheet.processCommand(input));
			if (input.equalsIgnoreCase("quit")) on = false;
			System.out.println();
		}
		
		in.close();
	}
}
