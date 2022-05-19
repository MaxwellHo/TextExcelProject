package textExcel;

public class EmptyCell implements Cell{
	
	public EmptyCell() {}
	
	
	public String abbreviatedCellText() {  // must be exactly length 10
		return "          ";
	}
	public String fullCellText() {  // text for individual cell inspection, not truncated or padded
		return "";
	}

}

