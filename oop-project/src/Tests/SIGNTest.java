package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Formules.SIGN;

public class SIGNTest {

	/**
	 * Deze test kijkt of de methode een error geeft als een van de parameters
	 * geen getal is Hiermee de parser van deze methode ook testen
	 */
	@Test
	public void test1() {
		String[] test = { "Hamza" };
		SIGN sign = new SIGN();
		assertEquals(sign.executable(test), "Error: parseDouble bij SIGN!");
	}
	
	//Test met een positieve paramater
	@Test
	public void test2() {
		String[] test = { "24" };
		SIGN sign = new SIGN();
		assertEquals(sign.executable(test), "1");
	}
	
	//Test met een negatieve paramater
	@Test
	public void test3() {
		String[] test = { "-68" };
		SIGN sign = new SIGN();
		assertEquals(sign.executable(test), "-1");
	}
	
	//Test met 0 als de paramater
	@Test
	public void test4() {
		String[] test = { "0" };
		SIGN sign = new SIGN();
		assertEquals(sign.executable(test), "0");
	}
	
	//Test met een decimaal als parameter
	@Test
	public void test5() {
		String[] test = { "-2138745.284" };
		SIGN sign = new SIGN();
		assertEquals(sign.executable(test), "-1");
	}
	
	//Test met een grote integer als de parameter
	@Test
	public void test6() {
		String[] test = { "100000000000000" };
		SIGN sign = new SIGN();
		assertEquals(sign.executable(test), "1");
	}
	
	//Test met een grote positieve decimaal
	@Test
	public void test7() {
		String[] test = { "103255.00324230000"};
		SIGN sign = new SIGN();
		assertEquals(sign.executable(test), "1");
	}
}
