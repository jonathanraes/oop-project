package OOP;

import Controller.Controller;
import Gui.View;


public class Main {

	public static void main(String[] args) {
		
		Spreadsheet spreadsheet = new Spreadsheet();
		View view = new View(spreadsheet);
		Controller controller = new Controller(view, spreadsheet);
		
		String writeFile = "test.xml";
		String readFile = "leesbestand.xml";
		
		//Spreadsheet sheet = Spreadsheet.readXML(writeFile);
		//sheet.writeXML(writeFile);
	

	}

}
