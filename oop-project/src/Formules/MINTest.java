package Formules;

/**
 * Testklasse voor Klasse MIN
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class MINTest {

	/**
	 * Deze test kijkt of de methode een error geeft als een van de parameters
	 * geen getal is Hiermee de parser van deze methode ook testen
	 */
	@Test
	public void test() {
		String[] test = { "Hamza", "74.0", "78" };
		MIN min = new MIN();
		assertEquals(min.executable(test), "74.0");
	}

	@Test
	public void test1() {
		String[] test = { "3.1", "4.0", "2.2" };
		MIN min = new MIN();
		assertEquals(min.executable(test), "2.2");
	}

	// Test met een negatieve waarde in de parameters
	@Test
	public void test2() {
		String[] test = { "-2", "74.0", "78" };
		MIN min = new MIN();
		assertEquals(min.executable(test), "-2.0");
	}

	// Test met meerdere waarden in String[]
	@Test
	public void test3() {
		String[] test = { "0", "1.0", "243", "245", "325", "3" };
		MIN min = new MIN();
		assertEquals(min.executable(test), "0.0");
	}

	// Test met hetzelfde getallen als parameters
	@Test
	public void test4() {
		String[] test = { "5.0", "5.0", "5.0", "5.0" };
		MIN min = new MIN();
		assertEquals(min.executable(test), "5.0");
	}

	// Test met meerdere negatieve waardes in de parameters
	@Test
	public void test5() {
		String[] test = { "-2", "-74.0", "-78" ,"-7"};
		MIN min = new MIN();
		assertEquals(min.executable(test), "-78.0");
	}
	
	// Test met twee keer hetzelfde negatieve waarde in de parameter
		@Test
		public void test6() {
			String[] test = { "-9", "74.0", "78","-9","54" };
			MIN min = new MIN();
			assertEquals(min.executable(test), "-9.0");
		}
		
		// Test met grote decimaal getallen
		@Test
		public void test7() {
			String[] test = { "20000938121452", "2387635", "7825213256" };
			MIN min = new MIN();
			assertEquals(min.executable(test), "2387635.0");
		}
}
