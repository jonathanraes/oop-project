package Formules;

import static org.junit.Assert.*;

import org.junit.Test;

public class PRODUCTTest {

	@Test
	public void test1() {
		String[] test = { "3","4","2" };
		PRODUCT product = new PRODUCT();
		assertEquals(product.executable(test), "24.0");
	}
	
	@Test
	public void test2() {
		String[] test = { "8","124","2" };
		PRODUCT product = new PRODUCT();
		assertFalse(product.executable(test).equals("2.0"));
	}
	
	// Deze test kijkt of de resultaat 0 wordt als een van de waardes 0 is.
	@Test
	public void test3() {
		String[] test = { "124","6","0" };
		PRODUCT product = new PRODUCT();
		assertEquals(product.executable(test), "0.0");
	}
	
	/**
	 * Deze test kijkt of de methode een error geeft als een van de parameters geen getal is
	 * Hiermee de parser van deze methode ook testen 
	 */
	@Test
	public void test4() {
		String[] test = { "3","4","hamza" };
		PRODUCT product = new PRODUCT();
		assertEquals(product.executable(test), "Error: parseDouble bij PRODUCT!");
	}
	
	
}
