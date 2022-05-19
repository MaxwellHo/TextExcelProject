package textExcel;

import java.util.ArrayList;

public class FormulaCell extends RealCell{ 
	private String formula;
	private Spreadsheet sheet;
	
	public FormulaCell(String input, Spreadsheet spreadsheet) //constructor
	{
		super(input);
		this.formula = input;
		this.sheet = spreadsheet;
		formula = input;
	}
	
	public String fullCellText() //returns the full cell text
	{
		return formula;
	}
	
	public double getDoubleValue() //runs through the given formula and returns final answer of formula
	{
		double total = 0;
		String equation = "";
		equation = formula.substring(2,formula.length() - 2).toUpperCase();
		String[] splittingEquation = equation.split(" ");
		if(splittingEquation[0].equalsIgnoreCase("sum")) { 
			total = sum(splittingEquation[1]);
		} else if(splittingEquation[0].equalsIgnoreCase("avg")) { 
			total = average(splittingEquation[1]); 
		} else {
			total = parse(splittingEquation[0]); 
			for(int i = 1; i < splittingEquation.length; i+=2) {
				String operation = splittingEquation[i];
				double formulating = parse(splittingEquation[i+1]); 
				if(operation.equals("+")) {
					total += formulating; 
				} else if(operation.equals("*")) {
					total *= formulating; 
				} else if(operation.equals("-")) {
					total -= formulating;
				} else if (operation.equals("/")) { 
					total /= formulating; 
				}
			}
		}
		return total;
	}
	

	
	private double sum(String range) {//sums up all cells in the range
		ArrayList<String> cells = cellRangeArray(range); 
		double total = 0;
		for(int i = 0; i < cells.size(); i++) {
			total += parse(cells.get(i));
		}
		return total; 
	}
	
	private double average(String range) {//caluclates average of cell in the range
			double total = 0;
			ArrayList<String> cells = cellRangeArray(range);
			for(int i = 0; i < cells.size(); i++) {
				total += parse(cells.get(i));
			}
			double dividedTotal = (total/cells.size()); 
			return dividedTotal;
			
		}
	
	private double parse(String cell)  {//parse through cell and returns the value of the cell
		
		
		double value = 0;
		int row = cell.charAt(0);
		if(row >= 'A' && row <= 'Z') {
			SpreadsheetLocation location = new SpreadsheetLocation(cell); 
			RealCell loc = (RealCell)this.sheet.getCell(location); 
			double num = loc.getDoubleValue();
			value = num;
		} else if(row >= 'a' && row <= 'z') {
			SpreadsheetLocation location = new SpreadsheetLocation(cell); 
			RealCell loc = (RealCell)this.sheet.getCell(location); 
			double num = loc.getDoubleValue();
			value = num;
		} else {
			double num = Double.parseDouble(cell);
			value = num;
		}
		return value;
	}
	
	
	private ArrayList<String> cellRangeArray(String range) {//gets range, loops thorugh colums and rows to adds current colum to String range
		
		String[] split = range.split("-",2);
		String beginning = split[0]; 
		String ending = split[1]; 
		char ColumnBegin = beginning.charAt(0);
		char ColumnEnd = ending.charAt(0);
		int RowBegin = Integer.parseInt(beginning.substring(1));
		int rowEnd = Integer.parseInt(ending.substring(1)); 
		ArrayList<String> Strings = new ArrayList<>(); 
		
		for(char columnCount = ColumnBegin; columnCount <= ColumnEnd; columnCount++) { 
			for(int rowCount = RowBegin; rowCount <= rowEnd; rowCount++) { 
				String value = (rowCount + ""); 
				Strings.add(columnCount + value); 
			}
		}
		return Strings; 
	}
	
	
	
	
	
}