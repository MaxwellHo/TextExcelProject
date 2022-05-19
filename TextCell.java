package textExcel;

public class TextCell implements Cell {
	
	private String cell1;
	
	TextCell(String text) { //constructor
		cell1 = text.substring(1,text.length()-1);
	}
	
	
	public String abbreviatedCellText() { //adds 10 spaces and substrings it to 10 characters
		return (cell1 + "          ").substring(0,10);	
	}
	
	@Override
	public String fullCellText() { //returns String with quotes
		return "\"" + cell1 + "\"";
	}
	

}
