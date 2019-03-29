package textExcel;

public class RealCell implements Cell {
	private String textvalue;
	
	public RealCell(String textvalue) { //all the other cells will call the super, this constructor
		this.textvalue = textvalue; //8.99
	}
	public Double getDoubleValue() {
		return Double.parseDouble(textvalue); 
	}
	
	public String fullCellText() { 
		return textvalue; 
	}

	public String abbreviatedCellText() {
		String tempText = getDoubleValue() + "          "; 
		return tempText.substring(0, 10); 
	}
	
	}

	