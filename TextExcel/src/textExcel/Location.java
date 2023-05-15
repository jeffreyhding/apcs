package textExcel;

/** 
 * @author Jeffrey Ding
 * @version 02/23/2023
 */ 

public interface Location
{
	// stores a location in letter/number format (ex: B6)
	// implemented by the SpreadsheetLocation class
	int getRow(); // gets row of this location
	int getCol(); // gets column of this location
}
