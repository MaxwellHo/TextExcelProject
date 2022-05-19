package textExcel;

public class RealCell implements Cell{
	
	private String valueString;
	
	public RealCell(String value) { //constructor
		valueString = value;
	}
	
	public String abbreviatedCellText() { //abreviates string
		return (getDoubleValue() + "          ").substring(0,10);
	}
	
	public String fullCellText() {
		return valueString;
	}
	
	//@Override
	public double getDoubleValue() {//changes a string to a double
		double string = Double.parseDouble(valueString);
		return string;
	}
}
