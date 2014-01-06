package Formules;

import static org.junit.Assert.*;

import org.junit.Test;

public class SQRTTest {

	/**
	 * Deze test kijkt of de methode een error geeft als een van de parameters
	 * geen getal is Hiermee de parser van deze methode ook testen
	 */
	@Test
	public void test1() {
		String[] test = { "text" };
		SQRT sqrt = new SQRT();
		assertEquals(sqrt.executable(test), "Error: parseDouble bij SQRT!");
	}

	// Een positief geheel getal
	@Test
	public void test2() {
		String[] test = { "25" };
		SQRT sqrt = new SQRT();
		assertEquals(sqrt.executable(test), "5.0");
	}

	// Een positieve decimaal getal als parameter
	@Test
	public void test3() {
		String[] test = { "25.8" };
		SQRT sqrt = new SQRT();
		assertEquals(sqrt.executable(test), "5.079370039680118");
	}

	// Een negatieve getal als parameter testen
	@Test
	public void test4() {
		String[] test = { "-9" };
		SQRT sqrt = new SQRT();
		assertEquals(sqrt.executable(test),
				"Error: Het getal waarvan de wortel moet berekend worden is negatief!");
	}

	// Een priem getal als parameter testen
	@Test
	public void test5() {
		String[] test = { "11" };
		SQRT sqrt = new SQRT();
		assertEquals(sqrt.executable(test), "3.3166247903554");
	}

	// Een grote decimaal getal als parameter testen
	@Test
	public void test6() {
		String[] test = { "61.0274762357" };
		SQRT sqrt = new SQRT();
		assertEquals(sqrt.executable(test), "7.812008463621887");
	}

	// Het getal 0 als parameter testen
	@Test
	public void test7() {
		String[] test = { "0" };
		SQRT sqrt = new SQRT();
		assertEquals(sqrt.executable(test), "0.0");
	}

}
