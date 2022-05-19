package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location

{
    
    private String cellName;
	
    public int getRow()
    {
        return Integer.parseInt(cellName.substring(1)) - 1;
    }

    @Override
    public int getCol()
    {
        return cellName.toUpperCase().charAt(0) - 'A';
    }
    
    public SpreadsheetLocation(String cellName)
    {
    	this.cellName = cellName.toUpperCase();
    }
    
}