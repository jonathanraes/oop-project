package OOP;
import static org.junit.Assert.*;

import org.junit.Test;

public class CellTest {

	@Test
	public void testCell() {
		Cell cell1 = new Cell(1,1,"Een");
		Cell cell2 = new Cell(1,1,"Een");
		assertNotNull(cell1);
		assertEquals(cell1,cell2);
	}

	@Test
	public void testGetRow() {
		Cell cell1 = new Cell(1,1,"Een");
		Cell cell2 = new Cell(5,1,"Twee");
		assertEquals(cell1.getRow(), 1);
		assertEquals(cell2.getRow(), 5);
		assertNotEquals(cell1.getRow(), 5);
	}

	@Test
	public void testGetCol() {
		Cell cell1 = new Cell(1,1,"Een");
		Cell cell2 = new Cell(5,6,"Twee");
		assertEquals(cell1.getCol(), 1);
		assertEquals(cell2.getCol(), 6);
		assertNotEquals(cell1.getRow(), 6);	}

	@Test
	public void testGetContent() {
		Cell cell1 = new Cell(1,1,"Een");
		Cell cell2 = new Cell(5,6,"Twee");
		assertEquals(cell1.getContent(), "Een");
		assertNotEquals(cell2.getContent(), "Een");
	}

	@Test
	public void testSetContent() {
		Cell cell1 = new Cell(1,1,"Een");
		cell1.setContent("Twee");
		assertEquals(cell1.getContent(), "Twee");
	}

	@Test
	public void testSetRow() {
		Cell cell1 = new Cell(1,1,"Een");
		cell1.setRow(5);
		assertEquals(cell1.getRow(), 5);
	}

	@Test
	public void testSetCol() {
		Cell cell1 = new Cell(1,1,"Een");
		cell1.setCol(5);
		assertEquals(cell1.getCol(), 5);	}

	@Test
	public void testToString() {
		Cell cell1 = new Cell(1,1,"Een");
		assertEquals(cell1.toString(), "Rij: 1\nKolom: 1\nContents: Een");
		
	}
}
