package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Formules.ROUNDUP;

public class ROUNDUPTest {

	// Afronden naar 0 cijfers achter de komma
	@Test
	public void test13() {
		String[] test = { "2.4533254", "0" };
		ROUNDUP r = new ROUNDUP();
		assertEquals(r.executable(test), "3");
	}

	// positieve afronding
	@Test
	public void test1() {
		String[] test = { "2.4533254", "3" };
		ROUNDUP r = new ROUNDUP();
		assertEquals(r.executable(test), "2.454");
	}

	// negative getal
	@Test
	public void test2() {
		String[] test = { "-2.4533254", "3" };
		ROUNDUP r = new ROUNDUP();
		assertEquals(r.executable(test), "-2.454");
	}

	@Test
	public void test3() {
		String[] test = { "10.541", "2" };
		ROUNDUP r = new ROUNDUP();
		assertEquals(r.executable(test), "10.55");
	}

	// string als parameter in het afrondings getal
	@Test
	public void test4() {
		String[] test = { "2.45234", "hamza" };
		ROUNDUP r = new ROUNDUP();
		assertEquals(r.executable(test), "Error1: Not a number!");
	}

	// een positieve int proberen te afronden naar
	@Test
	public void test5() {
		String[] test = { "6", "3" };
		ROUNDUP r = new ROUNDUP();
		assertEquals(r.executable(test), "6");
	}

	@Test
	public void test6() {
		String[] test = { "687", "-1" };
		ROUNDUP r = new ROUNDUP();
		assertEquals(r.executable(test), "690");
	}

	@Test
	public void test7() {
		String[] test = { "12345", "-2" };
		ROUNDUP r = new ROUNDUP();
		assertEquals(r.executable(test), "12400");
	}

	@Test
	public void test8() {
		String[] test = { "12345.352231", "-2" };
		ROUNDUP r = new ROUNDUP();
		assertEquals(r.executable(test), "12400");
	}

	// verkeerde parameter
	@Test
	public void test10() {
		String[] test = { "2 verkeerd!", "2" };
		ROUNDUP r = new ROUNDUP();
		assertEquals(r.executable(test), "Error1: Not a number!");
	}

	// 0 afronden
	@Test
	public void test9() {
		String[] test = { "0", "2" };
		ROUNDUP r = new ROUNDUP();
		assertEquals(r.executable(test), "0");
	}

	// Negatieve getal met een negatieve afronding
	@Test
	public void test11() {
		String[] test = { "-785432.9832", "-4" };
		ROUNDUP r = new ROUNDUP();
		assertEquals(r.executable(test), "-790000");
	}

	// Verkeerde parameter in het eerste getal!
	@Test
	public void test12() {
		String[] test = { "Helo", "2" };
		ROUNDUP r = new ROUNDUP();
		assertEquals(r.executable(test), "Error1: Not a number!");
	}

	
	// Afronding naar 6 cjifers cijfers achter de komma
	// terwijl er maar 2 cijfers achter de komma staan
	@Test
	public void test16() {
		String[] test = { "213.12", "6" };
		ROUNDUP r = new ROUNDUP();
		assertEquals(r.executable(test), "213.12");
	}

	
	// negatieve afronding die is meer dan het aantal cijfers in de linker deel
	// van getal om af to ronden!
	@Test
	public void test14() {
		String[] test = { "78.98", "-4" };
		ROUNDUP r = new ROUNDUP();
		assertEquals(r.executable(test), "10000");
	}
	
	@Test
	public void test15() {
		String[] test = { "972", "-5" };
		ROUNDUP r = new ROUNDUP();
		assertEquals(r.executable(test), "100000");
	}
}
