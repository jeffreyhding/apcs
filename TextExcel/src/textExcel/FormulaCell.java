package textExcel;

/** 
 * @author Jeffrey Ding
 * @version 02/23/2023
 */ 

public class FormulaCell extends RealCell implements Cell {
	
	private Spreadsheet sheet;

	public FormulaCell(String value, Spreadsheet sheet) {
		super(value);
		this.sheet = sheet;
	}
	
	@Override
	public String abbreviatedCellText() {
	// returns the evaluated formula value that will appear in the full Spreadsheet grid
		String text = Double.toString(getDoubleValue());
		if (text.length() > 10) return text.substring(0, 10);
		else {
			String spaces = "";
			for (int i = 0; i < (10 - text.length()); i++) spaces += " ";
			return text + spaces;
		}
	}

	@Override
	public String fullCellText() {
	// returns the full formula text of the FormulaCell
		return super.fullCellText();
	}

	public double getDoubleValue() {
	// returns the double value of the evaluated formula of the FormulaCell
		String[] arr = super.fullCellText().toUpperCase().substring(2, super.fullCellText().length() - 2).split(" ");
		
		// returns the average of the values of the specified cell range
		if (arr[0].equalsIgnoreCase("AVG")) {
			return operator(arr, true);
		}
		
		// returns the sum of the values of the specified cell range
		else if (arr[0].equalsIgnoreCase("SUM")) {
			return operator(arr, false);
		}
		
		// performs the arithmetic operations in the formula text of the FormulaCell
		double num = valueOf(arr[0]);
		double value = num;
		
		for (int i = 1; i < arr.length; i += 2) {
			num = valueOf(arr[i + 1]);
			if (arr[i].equals("+")) value += num;
			else if (arr[i].equals("-")) value -= num;
			else if (arr[i].equals("*")) value *= num;
			else if (arr[i].equals("/")) value /= num;
		}
		return value;
	}
	
	public boolean isNumeric (String str) {
	// checks if a String is a numeric value
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public boolean isLetter (char c) {
	// checks if a char is a letter
		if (c >= 'A' && c <= 'Z') return true;
		else return false;
	}
	
	public double valueOf (String str) {
	// checks if a formula term is a Cell reference and returns the double value of the term
		if (isLetter(str.charAt(0)) && isNumeric(str.substring(1))) {
			Location loc = new SpreadsheetLocation(str);
			return ((RealCell) sheet.getCell(loc)).getDoubleValue();
		} 
		else return Double.parseDouble(str);
	}
	
	public double operator(String[] arr, boolean avg) {
	// calculates the sum or average of the values of the specified cell range
		String cell1 = arr[1].substring(0, arr[1].indexOf("-")).toUpperCase();
		String cell2 = arr[1].substring(arr[1].indexOf("-") + 1).toUpperCase();
		
		double sum = 0.0;
		int count = 0;
		for (char c = cell1.charAt(0); c <= cell2.charAt(0); c++) {
			for (int i = Integer.parseInt(cell1.substring(1)); i <= Integer.parseInt(cell2.substring(1)); i++) {
				Location loc = new SpreadsheetLocation("" + (char) c + Integer.toString(i));
				sum += ((RealCell) sheet.getCell(loc)).getDoubleValue();
				count++;
			}
		}
		if (avg == true) return sum / count;
		else return sum;
	}
}
