package textExcel;

/** 
 * @author Jeffrey Ding
 * @version 02/23/2023
 */ 

public class TextCell implements Cell {
	
	private String text;

	public TextCell(String text) {
	// constructor for TextCell class
		this.text = text;
	}
	
	@Override
	public String abbreviatedCellText() {
	// returns the text that will appear in the full Spreadsheet grid
		if (text.length() >= 10) return text.substring(0, 10);
		else {
			String spaces = "";
			for (int i = 0; i < (10 - text.length()); i++) spaces += " ";
			return text + spaces;
		}
	}

	@Override
	public String fullCellText() {
	// returns the full text of the individual Cell  
		return "\"" + text + "\"";
	}
}
