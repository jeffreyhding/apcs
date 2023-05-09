package textExcel;

/** 
 * @author Jeffrey Ding
 * @version 02/23/2023
 */ 

public class PercentCell extends RealCell implements Cell {

	public PercentCell(String value) {
		super(value);
	}
	
	@Override
	public String abbreviatedCellText() {
	// returns the text that will appear in the full Spreadsheet grid
		String text = super.fullCellText();
		text = text.substring(0, text.indexOf("."));
		if (text.length() > 9) return text.substring(0, 9) + "%";
		else {
			String spaces = "";
			for (int i = 0; i < (9 - text.length()); i++) spaces += " ";
			return text + "%" + spaces;
		}
	}

	@Override
	public String fullCellText() {
	// returns the full decimal text of the PercentCell
		return Double.toString(getDoubleValue());
	}
	
	public double getDoubleValue() {
	// returns the double value of the stored field
		String text = super.fullCellText();
		return Double.parseDouble(text.substring(0, text.indexOf("%"))) / 100;
	}
}
