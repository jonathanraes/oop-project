package OOP;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Spreadsheet is the Class that holds all the Cells in an ArrayList.
 * It is the model class and handles the reading and writing of the xml files.
 */
public class Spreadsheet extends Observable{
	
	private static ArrayList<Cell> Spreadsheet;

	/**
	 * Constructor. Makes a private ArrayList with Cell objects
	 */
	public Spreadsheet() {
		Spreadsheet = new ArrayList<Cell>();
	}

	/**
	 * This method checks if the Object is a Cell object. If this is true it
	 * will add the cell to the ArrayList.
	 * @param Object Cell 
	 */
	public void add(Object cell) {
		if (cell instanceof Cell) {
			Cell add = (Cell) cell;

			Spreadsheet.add(add);
		}
	}

	/**
	 * This method will return the Cell object that is on index i.
	 * @param int index
	 * @return Cell on index
	 */
	public Cell get(int index) {
		return Spreadsheet.get(index);
	}
	
	/**
	 * This method returns the size of this
	 * @return int size
	 */
	public int size(){
		return Spreadsheet.size();
	}

	/**
	 * Reads the contents of the xml file and creates Cells which it puts in the ArrayList
	 * @param String - the filename
	 * @return Spreadsheet
	 */
	public static Spreadsheet readXML(String filename) {
		Spreadsheet readSheet = new Spreadsheet();
		try {
			// Maakt de Parser aan.
			File file = new File(filename);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();
			// Sorteert op CELL
			NodeList nList = doc.getElementsByTagName("CELL");
			
			
			for(int i = 0; i < nList.getLength(); i++){
				Node node = nList.item(i);
				
				if(node.getNodeType() == Node.ELEMENT_NODE){
					
					// Lees de content,row en column
					Element element = (Element) node;
					int col = Integer.parseInt(element.getAttribute("column"));
					int row = Integer.parseInt(element.getAttribute("row"));
					String content = node.getTextContent();
					content = content.replace("\n", "");
					
					//Maakt de cell en voegt hem toe.
					Cell cell = new Cell(row, col, content);					
					readSheet.add(cell);
					
					// Geeft de cell weer. Voor testen.
					//System.out.println(cell.toString());
				}			
				
			}			
						
		} catch (ParserConfigurationException | IOException | SAXException | NumberFormatException e) {
			e.printStackTrace();
		}
		return readSheet;
	}

	/**
	 * This methode makes a Document with all the values and Nodes of this. It then writes this to a xml- file with 
	 * the @param name. 
	 * @param String filename
	 */
	public void writeXML(String filename) {
		
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			
			// Spreadsheet element
			Element sheetElem = doc.createElement("SPREADSHEET");			
			doc.appendChild(sheetElem);
					
			// Maakt de Nodes aan
			for( int i =0; i < Spreadsheet.size(); i++){
				Cell cell = Spreadsheet.get(i);
				
				// Cell element
				Element cellElem = doc.createElement("CELL");
				sheetElem.appendChild(cellElem);
								
				// Cell attribute
				Attr row = doc.createAttribute("row");
				String rowValue = String.valueOf(cell.getRow());
				row.setValue(rowValue);
				Attr col = doc.createAttribute("column");
				String colValue = String.valueOf(cell.getCol());
				col.setValue(colValue);
				cellElem.setAttributeNode(col);
				cellElem.setAttributeNode(row);
				
				
				// Cell content
				cellElem.appendChild(doc.createTextNode(cell.getContent()));
			}
			
			// Nu schrijven naar xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			File writeFile = new File(filename);
			StreamResult result = new StreamResult(writeFile);
			
			transformer.transform(source, result);
			System.out.println("De file is geschreven.");
			
		}catch(Exception e){
			// TODO: precieze exception/ per exception apparte prints.
			System.out.println("Foutmelding in writeXML");
		}
	}
	
	public ArrayList<Cell> getCells(){
		return Spreadsheet;
	}

}
