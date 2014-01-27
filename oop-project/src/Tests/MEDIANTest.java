package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Formules.MEDIAN;

public class MEDIANTest {
	// Stringlijst met 5 gehele getallen in opeenvolgende volgorde. Antwoord: 8.
	@Test
	public void test1() {
		String[] test1 = {"4","6","8","10","33"};
		MEDIAN median = new MEDIAN();
		assertEquals(median.executable(test1),"8.0");
	}
	// Stringlijst met 6 getallen in opeenvolgende volgorde. Antwoord: (8.2+9.2)/2=8.7
	@Test
	public void test2() {
		String[] test2 = {"3.4","5.6","8.2","9.2","22.3","65"};
		MEDIAN median = new MEDIAN();
		assertEquals(median.executable(test2),"8.7");
	}
	// Stringlijst met 4 negatieve getallen in opeenvolgende volgorde. Antwoord: (-7.1+ -6.2)/2 = -6.65
	@Test
	public void test3() {
		String[] test3 = {"-321","-7.1","-6.2","-0.5"};
		MEDIAN median = new MEDIAN();
		assertEquals(median.executable(test3),"-6.65");
	}
	// Stringlijst met 6 positieve getallen in willekeurige volgorde. (31.4+23.13)/2 = 27.265.
	@Test
	public void test4() {
		String[] test4 = {"123","62.3","31.4","6.1","0.5","23.13"};
		MEDIAN median = new MEDIAN();
		assertEquals(median.executable(test4),"27.265");
	}
	// Stringlijst met alleen Strings. Levert error-message "NO NUMBERS FOUND" op.
	@Test
	public void test6() {
		String[] test6 = {"Dit","Zijn","Geen","Getallen"};
		MEDIAN median = new MEDIAN();
		assertEquals(median.executable(test6),"NO NUMBERS FOUND");
	}
	// Stringlijst met getallen en Strings.
	@Test
	public void test7() {
		String[] test7 = {"Dit is geen getal","62.3","Hoi","6.1","????","23.12", "-5"};
		MEDIAN median = new MEDIAN();
		assertEquals(median.executable(test7),"14.61");
	}
	
	

}
