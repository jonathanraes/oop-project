package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Formules.COUNTIF;

public class COUNTIFTest {
	// Vijf getallen, met de voorwaarde >4. Antwoord: 3.
	@Test
	public void test1() {
		String[] test1 = {">4","","","3","5.1","50","-1","5"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test1), "3");
	}
	// Vijfs dezelfde getallen als hierboven, maar met de voorwaarde <4. Antwoord: 3.
	@Test
	public void test2() {
		String[] test1 = {"<4","","","3","5.1","50","-1","5"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test1), "2");
	}
	// Vijf getallen, met de voorwaarde <>2. Antwoord: 4.
	@Test
	public void test3() {
		String[] test1 = {"<>2","","","2.1","28","-1","2","0"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test1), "4");
	}
	// Vijf getallen, met de voorwaarde >=5. Antwoord: 3.
	@Test
	public void test5() {
		String[] test1 = {">=5","","","3","5.1","50","-1","5"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test1), "3");
	}
	// Vijf getallen, met de voorwaarde <=5.1. Antwoord: 4.
	@Test
	public void test6() {
		String[] test1 = {"<=5.1","","","3","5.1","50","-1","5"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test1), "4");
	}
	// Vijf getallen, met de voorwaarde =4. Antwoord: 3.
	@Test
	public void test7() {
		String[] test1 = {"=4","","","3","5.1","50","-1","5"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test1), "0");
	}
	// Vijf getallen, zonder geldige voorwaarde. Antwoord: NO VALID LOGICAL EXPRESSION.
	@Test
	public void test8() {
		String[] test1 = {"1234","","","3","5.1","50","-1","5"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test1), "NO VALID LOGICAL EXPRESSION");
	}
	// Vijf getallen, twee keer dezelde, met de voorwaarde =5.1. Antwoord: 2.
	@Test
	public void test9() {
		String[] test1 = {"=5.1","","","3","5.1","50","-1","5.1"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test1), "2");
	}
// --------------------- Strings --------------------------------------
// Dit zijn dezelfde tests als hierboven, maar dan met een String eraan toegevoegd.
	
	// Vijf getallen en een String, met de voorwaarde >4. Antwoord: 3.
	@Test
	public void test10() {
		String[] test1 = {">4","","","3","5.1","50","-1","5", "getal"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test1), "3");
	}
	// Vijf dezelfde getallen als hierboven en een String, maar met de voorwaarde <4. Antwoord: 3.
	@Test
	public void test11() {
		String[] test1 = {"<4","","","3","5.1","50","-1","5", "getal"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test1), "2");
	}
	// Vijf getallen en een String, met de voorwaarde <>2. Antwoord: 5.
	@Test
	public void test12() {
		String[] test1 = {"<>2","","","2.1","28","1","-2","0", "getal"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test1), "5");
	}
	// Vijf getallen en een String, met de voorwaarde >=5. Antwoord: 3.
	@Test
	public void test13() {
		String[] test1 = {">=5","","","3","5.1","50", "getal","-1","5"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test1), "3");
	}
	// Vijf getallen en een String, met de voorwaarde <=5.1. Antwoord: 4.
	@Test
	public void test14() {
		String[] test1 = {"<=5.1","","","3","5.1", "getal","50","-1","5"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test1), "4");
	}
	// Vijf getallen en een String, met de voorwaarde =4. Antwoord: 3.
	@Test
	public void test15() {
		String[] test1 = {"=4","","","3", "getal","5.1","50","-1","5"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test1), "0");
	}
	// Vijf getallen en een String, zonder geldige voorwaarde. Antwoord: NO VALID LOGICAL EXPRESSION.
	@Test
	public void test16() {
		String[] test1 = {"1234","","","3","5.1", "getal","50","-1","5"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test1), "NO VALID LOGICAL EXPRESSION");
	}
	// Vijf getallen en een String, twee keer dezelde, met de voorwaarde =5.1. Antwoord: 2.
	@Test
	public void test17() {
		String[] test1 = {"=5.1","","","3", "getal","5.1","50","-1","5.1"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test1), "2");
	}
	// Vergelijking met J19, waarvan de inhoud getal is. Antwoord: 0.
	@Test
	public void test26() {
		String[] test = {"=getal","","", "-2.2", "1.4", "-5", "29", "getal", "Dit is een getal!"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test), "1");
	}
	// Vergelijking met J19, waarvan de inhoud getal is. Antwoord: 0.
	@Test
	public void test27() {
		String[] test = {"<getal","","", "-2.2", "1.4", "-5", "29", "getal", "Dit is een getal!"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test), "0");
	}
	
	
// --------------------------------- Cell ------------------------------------------
// Dit zijn wederom dezelfde tests als hierboven, maar dan met referenties naar cellen in de voowaarde. 
	// Vergelijking met een cel. Inhoud van cell B4 = 5. Antwoord: 3.
	@Test
	public void test18() {
		String[] test = {"<B4","","5", "2", "1.4", "-5", "29", "getal"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test), "3");
	}
	// Vergelijking met J19, waarvan de inhoud 2 is. Antwoord: 3.
	@Test
	public void test19() {
		String[] test = {"<>J19","","2", "2", "1.4", "-5", "29", "getal"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test), "3");
	}
	// Vergelijking met K29, waarvan de inhoud 200 is. Antwoord: 4.
	@Test
	public void test20() {
		String[] test = {"<=K29","","200", "2", "1.4", "-5", "290", "getal"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test), "3");
	}
	// Vergelijking met J19, waarvan de inhoud 1.3 is. Antwoord: 3.
	@Test
	public void test21() {
		String[] test = {">=J19","","1.3", "2", "1.4", "-5", "29", "getal"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test), "3");
	}
	// Vergelijking met J19, waarvan de inhoud 0 is. Antwoord: 3.
	@Test
	public void test22() {
		String[] test = {">J19","","0", "2", "1.4", "-5", "29", "getal"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test), "3");
	}
	// Vergelijking met J19, waarvan de inhoud -2.2 is. Antwoord: 1.
	@Test
	public void test23() {
		String[] test = {"=J19","","-2.2", "-2.2", "1.4", "-5", "29", "getal"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test), "1");
	}
	// Vergelijking met J19, waarvan de inhoud getal is. Antwoord: 1.
	@Test
	public void test24() {
		String[] test = {"=J19","","getal", "-2.2", "1.4", "-5", "29", "getal", "Is dit een getal?"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test), "1");
	}
	// Vergelijking met J19, waarvan de inhoud getal is. Antwoord: 0.
	@Test
	public void test25() {
		String[] test = {">J19","","getal", "-2.2", "1.4", "-5", "29", "getal", "Dit is een getal!"};
		COUNTIF countif = new COUNTIF();
		assertEquals(countif.executable(test), "0");
	}
	
}
