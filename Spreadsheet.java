package textExcel;



// Update this file with your own code.

public class Spreadsheet implements Grid
{
	//private Cell[][] sheet;

	
	private static Cell Empty = new EmptyCell();
	
	private Cell sheet[][];
	Spreadsheet() {
		sheet = new Cell[getRows()][getCols()];
		clearAll();
	}
	
	@Override
	public int getRows() {//gets # of rows
		return 20;
	}

	@Override
	public int getCols() {//gets # of cols
		return 12;
	}

	@Override
	public Cell getCell(Location loc) {// gets a specified cell location
		return sheet[loc.getRow()][loc.getCol()];
	}

	
	@Override
	public String getGridText() {//creates grid text
		String text = "   |";
		for(char letter =  'A'; letter <= 'L'; letter++) {
			text += letter + "         |";
		}
		text += "\n";
		for(int rows = 0; rows < 20; rows++) {
			text += (rows + 1) + " ";
			if(rows < 9) {
				text += " ";
			}
			text += "|";
			
			for(Cell cell : sheet[rows]) {
				text += cell.abbreviatedCellText() + "|";
			}
			text += "\n";
		}
		return text;
		
	} 
	
	
	public void clearAll() { //clears whole grid text
		for(int row = 0; row < getRows(); row++) {
			for(int col = 0; col < getCols(); col++) {
				sheet[row][col] = Empty;
			}
		}
	}
	
	
	@Override
	public String processCommand(String command) { //takes input from user to process it
		
		if(command.equals("")) {
			return "";		
		} else 
		if(command.contains(" = ")) {
			String[] splitCommand = command.split(" = ", 2);
			SpreadsheetLocation location = new SpreadsheetLocation(splitCommand[0]); 
			String commandInput = splitCommand[1];
			if(commandInput.substring(commandInput.length()) == "%") {
				sheet[location.getRow()][location.getCol()] = new PercentCell(splitCommand[1]);	
			} else if(commandInput.substring(0,1) == "\"") {
				sheet[location.getRow()][location.getCol()] = new TextCell(splitCommand[1]);	
			} else if(splitCommand[1].contains("(") && splitCommand[1].contains(")")) {
				sheet[location.getRow()][location.getCol()] = new FormulaCell(splitCommand[1], this);
			} else {
				sheet[location.getRow()][location.getCol()] = new ValueCell(splitCommand[1]); 
			}
		}else if(command == "clear") {
			if(command == "clear") {
				clearAll();
			} else {
				String[] splitCommand = command.split(" ", 2); 
				SpreadsheetLocation location = new SpreadsheetLocation(splitCommand[1]); 
				sheet[location.getRow()][location.getCol()] = new EmptyCell();
			}
		} else if(command.length() <= 4) { 
			Location location = new SpreadsheetLocation(command);
			return getCell(location).fullCellText();
		}
		return getGridText();
	}
	
	
	
	

}
