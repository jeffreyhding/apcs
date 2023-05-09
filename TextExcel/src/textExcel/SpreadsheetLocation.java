package textExcel;

/** 
 * @author Jeffrey Ding
 * @version 02/23/2023
 */ 

public class SpreadsheetLocation implements Location {
	
	private String cellName;
	
	public SpreadsheetLocation (String cellName) {
	// sets the name/location of the Cell
		this.cellName = cellName.toUpperCase();
	}
	
    @Override
    public int getRow() {
    // returns the integer index of the row
        return Integer.parseInt(cellName.substring(1)) - 1;
    }

    @Override
    public int getCol() {
    // returns in integer index of the column
        return cellName.charAt(0) - (char) 'A';
    }
}
