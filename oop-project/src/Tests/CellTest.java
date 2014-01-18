package Tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import OOP.Cell;

public class CellTest {
	Cell cell1;
	Cell cell2;
	Cell cell3;
	Cell cell4;
	Cell cell5;
	@Before
	public void setUp(){
		cell1 = new Cell(1,1,"Een");
		cell2 = new Cell(1,1,"Een");
		cell3 = new Cell(2,2,"Twee");
		cell5 = new Cell(5,6,"Vijf");
	}
	
	@Test
	public void testCell() {
		assertNotNull(cell1);
		assertEquals(cell1,cell2);
		cell1 = new Cell(1,1,"", "=SUM(1,1)");
		assertEquals(cell1, cell2);
		assertNotEquals(cell2, cell3);
		assertNotEquals(cell2, cell4);
	}

	@Test
	public void testGetRow() {
		assertEquals(cell1.getRow(), 1);
		assertEquals(cell3.getRow(), 2);
		assertNotEquals(cell1.getRow(), 5);
	}

	@Test
	public void testGetCol() {
		assertEquals(cell1.getCol(), 1);
		assertEquals(cell5.getCol(), 6);
		assertNotEquals(cell1.getRow(), 6);	}

	@Test
	public void testGetContent() {
		assertEquals(cell1.getContent(), "Een");
		assertNotEquals(cell3.getContent(), "Een");
	}

	@Test
	public void testSetContent() {
		cell1.setContent("Twee");
		assertEquals(cell1.getContent(), "Twee");
	}

	@Test
	public void testSetRow() {
		cell1.setRow(5);
		assertEquals(cell1.getRow(), 5);
	}

	@Test
	public void testSetCol() {
		cell1.setCol(5);
		assertEquals(cell1.getCol(), 5);	}

	@Test
	public void testToString() {
		assertEquals(cell1.toString(), "Rij: 1\nKolom: 1\nContents: Een");
		
	}
	
	@Test
	public void testAddFunction(){
		cell1.addFunction("=SUM(1,1)");
		assertEquals(cell1.getFunction(), "=SUM(1,1)");
	}
	
	@Test
	public void testGetFunction(){
		cell1.addFunction("=SUM(1,1)");
		assertEquals(cell1.getFunction(), "=SUM(1,1)");
	}
	
	@After
	public void tearDown(){
		cell1 = null;
		cell2 = null;
		cell3 = null;
		cell5 = null;
	}
}
