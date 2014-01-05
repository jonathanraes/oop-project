package Formules;

import static org.junit.Assert.*;

import org.junit.Test;

public class ISEVENTest {

	// Test met een kleine double.
	@Test
	public void test1() {
		String[] test1 = {"5.4"};
		ISEVEN iseven1 = new ISEVEN();
		assertEquals(iseven1.executable(test1), "FALSE");
	}
	// Test met een grotere double en meer decimale getallen.
	@Test
	public void test2() {
		String[] test2 = {"3214.43424"};
		ISEVEN iseven2 = new ISEVEN();
		assertEquals(iseven2.executable(test2), "TRUE");
	}
	// Test met een klein negatief decimaal getal.
	@Test
	public void test3() {
		String[] test3 = {"-0.5"};
		ISEVEN iseven3 = new ISEVEN();
		assertEquals(iseven3.executable(test3), "TRUE");
	}
	// Test met een groot negatief decimaal getal. 
	@Test
	public void test4() {
		String[] test4 = {"-213231.123"};
		ISEVEN iseven4 = new ISEVEN();
		assertEquals(iseven4.executable(test4), "FALSE");
	}
	// Test met een willekeurige String. Foutmelding levert: "#VALUE!".
	@Test
	public void test5() {
		String[] test5 = {"Dit is geen getal"};
		ISEVEN iseven5 = new ISEVEN();
		assertEquals(iseven5.executable(test5), "#VALUE!");
	}
	// Test met een String bestaande uit letters en cijfers. Foutmelding levert: "#VALUE!".
	@Test
	public void test6() {
		String[] test6 = {"5as1u23ig"};
		ISEVEN iseven6 = new ISEVEN();
		assertEquals(iseven6.executable(test6), "#VALUE!");
	}
	// Test meerde waardes in de String[]. Eerste is een geheel getal.
	@Test
	public void test7() {
		String[] test7 = {"4", "dsad", "213.23"};
		ISEVEN iseven7 = new ISEVEN();
		assertEquals(iseven7.executable(test7), "TRUE");
		}
	// Test meerde waardes in de String[]. Eerste is String.
	@Test
	public void test8() {
		String[] test8 = {"String", "5", "dsad", "213.23"};
		ISEVEN iseven = new ISEVEN();
		assertEquals(iseven.executable(test8), "#VALUE!");
	}
	// Test met een klein geheel negatief getal.
	@Test
	public void test9() {
		String[] test9 = {"-3"};
		ISEVEN iseven9 = new ISEVEN();
		assertEquals(iseven9.executable(test9), "FALSE");
	}

}
