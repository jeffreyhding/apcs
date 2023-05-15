package textExcel;

/** 
 * @author Jeffrey Ding
 * @version 02/23/2023
 */ 

public interface Grid 
{
	String processCommand(String command); // processes a user command, returns string to display, must be called in loop from main
	int getRows(); // returns number of rows in grid
	int getCols(); // returns number of columns in grid
	Cell getCell(Location loc); // returns cell at loc
	String getGridText(); // returns entire grid, formatted as text for display
}
