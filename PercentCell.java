package textExcel;

public class PercentCell extends RealCell{
	
	public PercentCell(String input) { //constructor
		super(input.substring(0, input.length()-1)); 
	}
	
	public String fullCellText() { //returns the fullcell text
		return ((getDoubleValue() / 100) + ""); 
	}
	
	public String abbreviatedCellText() { //returns the abbreviated cell text
		String String = super.fullCellText();
		if (String.contains(".")) {
			String = String.substring(0, String.indexOf("."));
		}
		return (String + "%          ").substring(0,10);
	}

}
