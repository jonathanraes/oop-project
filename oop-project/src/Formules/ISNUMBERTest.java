package Formules;

import static org.junit.Assert.*;

import org.junit.Test;

public class ISNUMBERTest {

	// Normaal geheel getal.
	@Test
	public void test1() {
		String[] test1 = {"10"};
		ISNUMBER isnumber = new ISNUMBER();
		assertEquals(isnumber.executable(test1),"TRUE");
	}
	// Groot decimaal getal.
	@Test
	public void test2(){
		String[] test2 = {"12938129837.1283698123"};
		ISNUMBER isnumber = new ISNUMBER();
		assertEquals(isnumber.executable(test2), "TRUE");
	}
	// Negatief groot geheel getal.
	@Test
	public void test3() {
		String[] test3 = {"-3213"};
		ISNUMBER isnumber = new ISNUMBER();
		assertEquals(isnumber.executable(test3),"TRUE");
		}
	// Willekeurige String bestaande uit alleen letters.
	@Test
	public void test4() {
		String[] test4 = {"Dit is geen getal"};
		ISNUMBER isnumber = new ISNUMBER();
		assertEquals(isnumber.executable(test4),"FALSE");
	}
	// String beginnend met een cijfer, maar ook bestaande uit letters en eindigent met een getal.
	@Test
	public void test5() {
		String[] test5 = {"6 is een getal, net zoals 2."};		
		ISNUMBER isnumber = new ISNUMBER();
		assertEquals(isnumber.executable(test5),"FALSE");
	}
	// String met een getal ergens in het midden..
	@Test
	public void test6() {
		String[] test6 = {"Ik ben 18 jaar."};
		ISNUMBER isnumber = new ISNUMBER();
		assertEquals(isnumber.executable(test6),"FALSE");
	}
	// String[] bestaande uit een samengesteld getal op de eerste plaats en woorden op de rest.
	@Test
	public void test7() {
		String[] test7 = {"2" + "3", "Is", "Een", "Getal"};
		ISNUMBER isnumber = new ISNUMBER();
		assertEquals(isnumber.executable(test7),"TRUE");
	}
	// Lege String en een getal in de String[].
	@Test
	public void test8() {
		String[] test8 = {"", "23"};
		ISNUMBER isnumber = new ISNUMBER();
		assertEquals(isnumber.executable(test8),"FALSE");
	}
	// Willekeurige String bestaande uit alleen letters.
	@Test
	public void test9() {
		String[] test9 = {"Negen","is","een","getal"};
		ISNUMBER isnumber = new ISNUMBER();
		assertEquals(isnumber.executable(test9),"FALSE");
	}
}
