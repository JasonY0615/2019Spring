package textExcel;

	public class TextCell implements Cell {
		private String input;
		public TextCell(String input) {
		this.input = input.substring(1, input.length()-1);
	}
    
	public String abbreviatedCellText() {
		//String Abb = input.substring(0, input.length()-1);
		String temp = input + "          ";
			return temp.substring(0, 10);
		}	

	public String fullCellText() {
		return "\"" + input + "\"";
	}
}

	
