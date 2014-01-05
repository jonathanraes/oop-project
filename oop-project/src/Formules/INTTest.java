package Formules;

import static org.junit.Assert.*;

import org.junit.Test;

public class INTTest {

	// Test met een kleine double.
	@Test
	public void test1() {
		String[] test1 = {"5.4"};
		INT inttest1 = new INT();
		assertEquals(inttest1.executable(test1), "5");
	}
	// Test met een grotere double en meer decimale getallen.
	@Test
	public void test2() {
		String[] test2 = {"3213.43424"};
		INT inttest2 = new INT();
		assertEquals(inttest2.executable(test2), "3213");
	}
	// Test met een klein negatief decimaal getal. (Wordt naar 'boven' afgerond)
	@Test
	public void test3() {
		String[] test3 = {"-0.5"};
		INT inttest3 = new INT();
		assertEquals(inttest3.executable(test3), "-1");
	}
	// Test met een groot negatief decimaal getal. (Wordt naar 'beneden' afgerond)
	@Test
	public void test4() {
		String[] test4 = {"-213231.123"};
		INT inttest4 = new INT();
		assertEquals(inttest4.executable(test4), "-213231");
	}
	// Test met een willekeurige String. Foutmelding levert: "NaN".
	@Test
	public void test5() {
		String[] test5 = {"Dit is geen getal"};
		INT inttest5 = new INT();
		assertEquals(inttest5.executable(test5), "NaN");
	}
	// Test met een String bestaande uit letters en cijfers. Foutmelding levert: "NaN".
	@Test
	public void test6() {
		String[] test6 = {"5as1u23ig"};
		INT inttest6 = new INT();
		assertEquals(inttest6.executable(test6), "NaN");
	}
	// Test meerde waardes in de String[]. Eerste is een geheel getal. (Levert "5").
	@Test
	public void test7() {
		String[] test7 = {"5", "dsad", "213.23"};
		INT inttest7 = new INT();
		assertEquals(inttest7.executable(test7), "5");
		}
	// Test meerde waardes in de String[]. Eerste is String. (Levert "NaN").
	@Test
	public void test8() {
		String[] test8 = {"String", "5", "dsad", "213.23"};
		INT inttest8 = new INT();
		assertEquals(inttest8.executable(test8), "NaN");
	}
}
