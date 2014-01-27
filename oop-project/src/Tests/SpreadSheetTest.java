package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import OOP.Cell;
import OOP.Spreadsheet;

public class SpreadSheetTest {
	Spreadsheet testsheet;
	Cell cell1;
	Cell cell2;
	Cell cell3;
	Cell cell5;
	Cell emptycell1;
	Cell emptycell;
	String XML;
	@Before
	public void setUp() throws Exception {
		testsheet = new Spreadsheet();
		cell1 = new Cell(1,1,"Een");
		cell2 = new Cell(1,1,"Een");
		cell3 = new Cell(2,2,"Twee");
		cell5 = new Cell(5,6,"Vijf");
		emptycell1 = new Cell(1,1,"");
		emptycell = new Cell(55,3,"");
		XML = "TestingFIles/simpel.xml";
	}

	@After
	public void tearDown() throws Exception {
		//testsheet.clearSheet();
	}
	
	@Test
	public void testSpreadsheet() {
		assertNotNull(testsheet);
	}

	@Test
	public void testAdd() {
		testsheet.add(cell1);
		testsheet.add("Not a cell");
		assertEquals(testsheet.get(0), cell1);
		assertEquals(testsheet.size(), 1);
		testsheet.add(cell2);
		assertEquals(testsheet.size(), 1);
		assertEquals(testsheet.get(0), cell2); //A cell with pre-existing row and column is replaced
		testsheet.add(emptycell);
		assertEquals(testsheet.size(), 1); //empty cell is not added
		testsheet.add(emptycell1);
		assertEquals(testsheet.size(), 0); //The cell existed so was overwritten but it was empty so it was removed
	}

	@Test
	public void testGet() {
		testsheet.add(cell3);
		assertEquals(testsheet.get(0), cell3);
	}

	@Test
	public void testSize() {
		assertEquals(testsheet.size(), 0);
		testsheet.add(cell1);
		assertEquals(testsheet.size(), 1);
		testsheet.add("Not a cell");
		assertEquals(testsheet.size(), 1);
	}

	@Test
	public void testReadXML() {
		testsheet = Spreadsheet.readXML(XML);
		Spreadsheet failsheet = Spreadsheet.readXML("TestingFiles/simple.xml");
		assertEquals(testsheet.getCellAt(5, 3).getContent(), "=SUM(A5:B5)");
	}

	@Test
	public void testWriteXML() {
		testsheet = Spreadsheet.readXML(XML);
		testsheet.writeXML("TestingFiles/output.xml");
		testsheet.writeXML("TestFiles/output.xml");
		testsheet.add(func);
		testsheet.writeXML("C:/Users/Jonathan/git/oop-project/oop-project/bin/Tests/testwrite.xml");
	}

	@Test
	public void testGetCells() {
		ArrayList<Cell> cells = new ArrayList<>();
		cells.add(cell1);
		testsheet.add(cell1);
		assertEquals(testsheet.getCells(), cells);
	}

	@Test
	public void testGetCellAt() {
		testsheet.add(cell1);
		testsheet.add(cell5);
		assertEquals(testsheet.getCellAt(1, 1), cell1);
		assertEquals(testsheet.getCellAt(5, 6), cell5);
		assertEquals(testsheet.getCellAt(5, 7), null);
	}

	@Test
	public void testClearSheet() {
		testsheet.add(cell1);
		testsheet.add(cell5);		
		assertEquals(testsheet.size(), 2);
		testsheet.clearSheet();
		assertEquals(testsheet.size(), 0);
	
	}
}
