package OOP;
import static org.junit.Assert.*;

import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void testSpreadsheet() {
		Spreadsheet s = new Spreadsheet();
		assertNotNull(s);
	}
	
	@Test
	public void testAdd(){
		Spreadsheet s = new Spreadsheet();
		Cell cell1 = new Cell(1,1,"Eerste rij");
		Cell cell2 = new Cell(2,1,"Tweede rij");
		s.add(cell1);
		s.add(cell1);
		s.add(cell2);
		assertEquals(s.get(0), cell1);
		assertEquals(s.get(0), s.get(1));
		assertEquals(s.get(2), cell2);
	}
	
	

}
