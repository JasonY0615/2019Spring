package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private int row =20;
	private int col =12; 
	private Cell[][] sheet = new Cell[row][col];
	public Spreadsheet() {
		clear();
	}

	public String processCommand(String command)
		{
			String[] userInput = command.split(" ", 3);
			
			if((userInput[0].toLowerCase().equals("clear")) && userInput.length == 2) {
				clearCell(userInput[1]);
			}else if(userInput[0].toLowerCase().equals("clear")) {
				clear();
			}else if(userInput.length == 1 ) {
				SpreadsheetLocation loc = new SpreadsheetLocation(userInput[0]);
				return getCell(loc).fullCellText();
			}else if(userInput.length == 3) {
				assignCell(userInput[0], userInput[2]); 
				
			}else {
				return "Invalid command";
			}
	return getGridText();
}
	
	
	public void clearCell (String input) {
		SpreadsheetLocation cellLocation = new SpreadsheetLocation(input);
		sheet[cellLocation.getRow()][cellLocation.getCol()] = new EmptyCell();
	}
	public void clear() { 
		for(int i = 0; i < row; i++) { 
			for(int j = 0; j < col; j++) {
				sheet[i][j] = new EmptyCell();
			}
		} 
	}
	public void assignCell(String cellName, String value) {
 
		
		SpreadsheetLocation cellLocation = new SpreadsheetLocation(cellName);
		// if statements to check for which cell it  is
		if(value.startsWith("\"") && value.endsWith("\"")) { //check for text cell
			
			sheet[cellLocation.getRow()][cellLocation.getCol()] = new TextCell(value);  
		}
		else if (value.endsWith("%")){ // 8.99%
	
			sheet[cellLocation.getRow()][cellLocation.getCol()] = new PercentCell(value);	
	}
	else if (value. startsWith("(") && value.endsWith(")")){  //(a1 + 1)
		
		sheet[cellLocation.getRow()][cellLocation.getCol()] = new FormulaCell(value);
	}
	else { // a1 = 20
		
		sheet[cellLocation.getRow()][cellLocation.getCol()] = new ValueCell(value);
		
	}
		
}
	//a1 = 8.99% percent cell
			// a1 = 20 value cell
			//a1 = (a1-29) forumla cell
			//value = 8.99% as a string
			//inputed into the percent cell constructor
	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return row;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return col;
	}

	@Override
	public Cell getCell(Location loc)
	{
		return sheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText() // the numbers off see, as well as the text column at the top
	//printing the column text on the top outside of the for loop
	// so you can add spaces to it 
	{
		String fullsheet = "   "; 
		for(char i = 'A'; i <= 'L'; i++) {
			fullsheet += ("|" + i + "         ");
		}
		fullsheet += "|\n";
		// adding the number + the two spaces, substring (0,3) only print out 3 characters
		for(int j = 1; j <= row; j ++) {
			if(j >= 10) { 
				fullsheet +=  j + " |";
			}
			else {
				fullsheet +=  j + "  |"; 
			}
			for (int a = 0; a < col; a ++) {
				SpreadsheetLocation loc = new SpreadsheetLocation(j-1,a);
				fullsheet += getCell(loc).abbreviatedCellText(); 
				fullsheet += "|"; 
			}
			fullsheet += "\n"; 
		}
		return fullsheet; 
	}

}
