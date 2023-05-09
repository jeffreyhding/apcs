package textExcel;

/** 
 * @author Jeffrey Ding
 * @version 02/23/2023
 */ 

public class RealCell implements Cell {

	private String value;
	
	public RealCell(String value) {
		this.value = value;
	}
	
	@Override
	public String abbreviatedCellText() {
	// returns the text that will appear in the full Spreadsheet grid
		String abrvText = Double.toString(getDoubleValue());
		if (value.length() > 10) return value.substring(0, 10);
		else {
			String spaces = "";
			for (int i = 0; i < (10 - abrvText.length()); i++) spaces += " ";
			return abrvText + spaces;
		}
	}

	@Override
	public String fullCellText() {
	// returns the full text of the RealCell
		return value;
	}

	public double getDoubleValue() {
	// returns the double value of the stored field
		return Double.parseDouble(value);
	}
}
