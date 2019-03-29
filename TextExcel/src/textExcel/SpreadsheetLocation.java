package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location {
	private int row;
	private int col;
    public SpreadsheetLocation(String cellName) {
    	col = (cellName.toUpperCase().charAt(0)-65);
    	row = Integer.parseInt(cellName.substring(1))-1; 
    }

    public SpreadsheetLocation(int row, int col) {
    	this.row = row; 
    	this.col = col;  
 }
	public int getRow()
    {
        // TODO Auto-generated method stub
        return row;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return col;
    }
    
    

}
