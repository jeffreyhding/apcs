package textExcel;

/** 
 * @author Jeffrey Ding
 * @version 02/23/2023
 */ 

public class EmptyCell implements Cell {
	
	public EmptyCell() {
	// empty constructor for EmptyCell class
	}

	@Override
	public String abbreviatedCellText() {
	// returns the text that will appear in the full Spreadsheet grid
		return "          ";
	}

	@Override
	public String fullCellText() {
	// returns the full text of the individual Cell  
		return "";
	}

}
