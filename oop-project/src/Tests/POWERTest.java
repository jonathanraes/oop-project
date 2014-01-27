package Tests;
/**
 * Test voor de klasse POWER
 */
import static org.junit.Assert.*;

import org.junit.Test;

import Formules.POWER;

public class POWERTest {

	/**
	 * Deze test kijkt of de methode een error geeft als een van de parameters geen getal is
	 * Hiermee de parser van deze methode ook testen 
	 */
	@Test
	public void test() {
		String[] test = { "3", "hamza" };
		POWER power = new POWER();
		assertEquals(power.executable(test), "Error: parseDouble bij POWER!");
	}
	
	// Test met twee gehele getallen.
	@Test
	public void test1() {
		String[] test = { "5", "2" };
		POWER power = new POWER();
		assertEquals(power.executable(test), "25.0");
	}

	// Test met een double en een integer.
	@Test
	public void test2() {
		String[] test = { "2.4", "3" };
		POWER power = new POWER();
		assertEquals(power.executable(test), "13.823999999999998");
	}

	// Test met een double en een integer.
	@Test
	public void test3() {
		String[] test  = { "5", "3.975" };
		POWER power = new POWER();
		assertEquals(power.executable(test), "600.3517310809962");
	}

	// Test: tot de macht 0 is altijd 1 
	@Test
	public void test4() {
		String[] test = { "547", "0" };
		POWER power = new POWER();
		System.out.println(power.executable(test));
		assertEquals(power.executable(test), "1.0");
	}
	
	// 0 tot de macht een willekeurige getal is altijd 0
	@Test
	public void test5() {
		String[] test = { "0", "387" };
		POWER power = new POWER();
		System.out.println(power.executable(test));
		assertEquals(power.executable(test), "0.0");
	}

	// 1 tot de macht een willekeurige getal is altijd 1
	@Test
	public void test6() {
		String[] test = { "1", "387" };
		POWER power = new POWER();
		System.out.println(power.executable(test));
		assertEquals(power.executable(test), "1.0");
	}

	@Test
	public void test7() {
		String[] test = { "4", "1" };
		POWER power = new POWER();
		System.out.println(power.executable(test));
		assertEquals(power.executable(test), "4.0");
	}

}
