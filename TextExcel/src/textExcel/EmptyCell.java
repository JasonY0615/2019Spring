// Jason Yang 
package textExcel;

public class EmptyCell implements Cell {
	public String abbreviatedCellText() {
		return "          "; //return 10 spaces
	}
	
	public String fullCellText() {
		return "";
	}
}
