package textExcel;


public class PercentCell extends RealCell{

public PercentCell(String textvalue){
	super(textvalue.substring(0,textvalue.length()-1)); 
	//System.out.println(super.fullCellText());
	
}

public String abbreviatedCellText() {
	double num= getDoubleValue();
	int whole = (int) num;
	String 	aabb =whole + "%"+ "          "; 
	
	return aabb.substring(0,10);
}

public String fullCellText() { //11.25% 11%  a20 = 11.25%
	return getDoubleValue()/100 + ""; //0.1125 0.11 11%
}


	
}