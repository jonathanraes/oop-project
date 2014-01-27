package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Formules.ROUNDDOWN;

public class ROUNDDOWNTest {

	// Afronding naar 0 cijfers achter de komma
	@Test
	public void test1() {
		String[] test = { "213.12", "0" };
		ROUNDDOWN r = new ROUNDDOWN();
		assertEquals(r.executable(test), "213");
	}

	// #1 Positieve double met positieve afronding
	@Test
	public void test2() {
		String[] test = { "598.12345", "1" };
		ROUNDDOWN r = new ROUNDDOWN();
		assertEquals(r.executable(test), "598.1");
	}

	// #2 Positieve double met positieve afronding
	@Test
	public void test3() {
		String[] test = { "213.1223482", "5" };
		ROUNDDOWN r = new ROUNDDOWN();
		assertEquals(r.executable(test), "213.12234");
	}

	// Positieve double met negatieve afronding
	@Test
	public void test4() {
		String[] test = { "213.12", "-1" };
		ROUNDDOWN r = new ROUNDDOWN();
		assertEquals(r.executable(test), "210");
	}

	// Positieve int met positieve afronding
	@Test
	public void test5() {
		String[] test = { "682", "2" };
		ROUNDDOWN r = new ROUNDDOWN();
		assertEquals(r.executable(test), "682");
	}

	// Positieve double met een verkeerde parameter in de afronding!
	@Test
	public void test6() {
		String[] test = { "2.45234", "hamza" };
		ROUNDDOWN r = new ROUNDDOWN();
		assertEquals(r.executable(test), "Error1: Not a number!");
	}

	// 2 kommas!
	@Test
	public void test7() {
		String[] test = { "357.34.24", "2" };
		ROUNDDOWN r = new ROUNDDOWN();
		assertEquals(r.executable(test), "Error1: Not a number!");
	}

	// verkeerde parameter
	@Test
	public void test8() {
		String[] test = { "2 verkeerd!", "2" };
		ROUNDDOWN r = new ROUNDDOWN();
		assertEquals(r.executable(test), "Error1: Not a number!");
	}

	// 0 afronden
	@Test
	public void test9() {
		String[] test = { "0", "2" };
		ROUNDDOWN r = new ROUNDDOWN();
		assertEquals(r.executable(test), "0");
	}

	// Negatieve getal met een negatieve afronding
	@Test
	public void test10() {
		String[] test = { "-785432.9832", "-4" };
		ROUNDDOWN r = new ROUNDDOWN();
		assertEquals(r.executable(test), "-780000");
	}

	// Verkeerde parameter in het eerste getal!
	@Test
	public void test11() {
		String[] test = { "Helo", "2" };
		ROUNDDOWN r = new ROUNDDOWN();
		assertEquals(r.executable(test), "Error1: Not a number!");
	}

	// Positieve getal met een negatieve afronding
	@Test
	public void test12() {
		String[] test = { "785432.9832", "-4" };
		ROUNDDOWN r = new ROUNDDOWN();
		assertEquals(r.executable(test), "780000");
	}

	// Afronding naar 6 cjifers cijfers achter de komma
	// terwijl er maar 2 cijfers achter de komma staan
	@Test
	public void test13() {
		String[] test = { "213.12", "6" };
		ROUNDDOWN r = new ROUNDDOWN();
		assertEquals(r.executable(test), "213.12");
	}

	// negatieve afronding die is meer dan het aantal cijfers in de linker deel
	// van getal om af to ronden!
	@Test
	public void test14() {
		String[] test = { "78.98", "-4" };
		ROUNDDOWN r = new ROUNDDOWN();
		assertEquals(r.executable(test), "0");
	}

}
