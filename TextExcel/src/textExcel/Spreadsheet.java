package textExcel;

/** 
 * @author Jeffrey Ding
 * @version 02/23/2023
 */ 

public class Spreadsheet implements Grid {
	
	private Cell[][] sheet;

	public Spreadsheet() {
		this.sheet = new Cell[20][12];
		for (int i = 0; i < sheet.length; i ++) {
			for (int j = 0; j < sheet[i].length; j++) {
				sheet[i][j] = new EmptyCell();
			}
		}
	}
	
	@Override
	public String processCommand(String command) {
	// returns the result of the processed command
		
		// input: <cell>
		// returns the full text of the specified Cell
		if (isLetter(command.charAt(0)) && isNumeric(command.substring(1))) {
			Location loc = new SpreadsheetLocation(command);
			return getCell(loc).fullCellText();
		}
		
		// input: <cell> = <value>
		// assigns a value to a Cell and returns entire sheet
		else if (command.contains("=")) {
			// assigns a String value to a TextCell
			if (command.charAt(command.indexOf("=") + 2) == ('\"')) {
				Location loc = new SpreadsheetLocation(command.substring(0, command.indexOf(" = ")));
				sheet[loc.getRow()][loc.getCol()] = new TextCell(command.substring(command.indexOf("\"") + 1, command.lastIndexOf("\"")));
			}
			
			// assigns a percent value to a PercentCell
			else if (command.contains("%")) {
				Location loc = new SpreadsheetLocation(command.substring(0, command.indexOf(" = ")));
				sheet[loc.getRow()][loc.getCol()] = new PercentCell(command.substring(command.indexOf("=") + 2));
			}
			
			// assigns a formula to a FormulaCell
			else if (command.contains("(")) {
				Location loc = new SpreadsheetLocation(command.substring(0, command.indexOf(" = ")));
				sheet[loc.getRow()][loc.getCol()] = new FormulaCell(command.substring(command.indexOf("=") + 2), this);
			}
			
			// assigns a double value to a ValueCell (same as RealCell)
			else {
				Location loc = new SpreadsheetLocation(command.substring(0, command.indexOf(" = ")));
				sheet[loc.getRow()][loc.getCol()] = new ValueCell(command.substring(command.indexOf("=") + 2));
			}
			
			return getGridText();
		}
		
		// input: clear
		// clears entire sheet and returns entire sheet
		else if (command.equalsIgnoreCase("clear")) {
			for (int i = 0; i < sheet.length; i++) for (int j = 0; j < sheet[i].length; j++) sheet[i][j] = new EmptyCell();
			return getGridText();
		}
		
		// input: clear <cell>
		// clears specified Cell and returns entire sheet
		else if (command.toLowerCase().contains("clear ")) {
			Location loc = new SpreadsheetLocation(command.substring(command.indexOf(" ") + 1));
			sheet[loc.getRow()][loc.getCol()] = new EmptyCell();
			return getGridText();
		}
		
		//input: quit
		// ends the program
		else if (command.equalsIgnoreCase("quit")) return "program ended";				
		
		else return "";
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

	@Override
	public int getRows() {
	// returns the number of rows
		return 20;
	}

	@Override
	public int getCols() {
	// returns the number of columns
		return 12;
	}

	@Override
	public Cell getCell(Location loc) {
	// returns the Cell at the passed location
		return sheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText() {
	// returns a String containing the entire Spreadsheet grid
		String grid = "   |";
		for (char x = 'A'; x <= 'L'; x++) grid += x + "         |";
		
		for (int i = 1; i <= 20; i++) {
			grid += "\n";
			if (i < 10) grid += i + "  |";
			else grid += i + " |";
			for (char y = 'A'; y <= 'L'; y++) grid += getCell(new SpreadsheetLocation(y + "" + i)).abbreviatedCellText() + "|";
		}
		return grid + "\n";
	}
}
