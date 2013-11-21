
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class ReadXML {
	
	/**
	 * Reads the contents of the xml file and creates a cell objects from it.
	 * @param file the xml file as input
	 */
	public static void readXML(File file){
		//String filename = "file.xml";
		try {
			//File file = new File(filename);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("CELL");
			
			
			for(int i = 0; i < nList.getLength(); i++){
				Node node = nList.item(i);
				
				if(node.getNodeType() == Node.ELEMENT_NODE){
					Element element = (Element) node;
					int col = Integer.parseInt(element.getAttribute("column"));
					int row = Integer.parseInt(element.getAttribute("row"));
					String content = node.getTextContent();
					content = content.replace("\n", "");
					Cell cell = new Cell(row, col, content);
					System.out.println(cell.toString());
				}
				
				
			}
						
		} catch (ParserConfigurationException | IOException | SAXException | NumberFormatException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
