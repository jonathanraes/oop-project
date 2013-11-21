
public class main {

	public static void main(String[] args) {


		String writeFile = "test.xml";
		String readFile = "leesbestand.xml";
		
		Spreadsheet sheet = Spreadsheet.readXML(writeFile);
		//sheet.writeXML(writeFile);
		
		for( int i=0; i < sheet.size() ; i++){
			System.out.println(sheet.get(i).toString());
			
		}
		
		

	}

}
