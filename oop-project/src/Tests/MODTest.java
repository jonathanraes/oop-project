package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Formules.MOD;

public class MODTest {
	
	/**
	 * Deze test kijkt of de methode een error geeft als een van de parameters geen getal is
	 * Hiermee de parser van deze methode ook testen 
	 */
	@Test
	public void test() {
		String[] test = {"HaHa","2"};
		MOD mod = new MOD();
		System.out.println(mod.executable(test));
		assertEquals(mod.executable(test), "Error: parseDouble bij MOD!");
	}
	
	
	@Test
	public void test1() {
		String[] test = {"5","2"};
		MOD mod = new MOD();
		assertEquals(mod.executable(test), "1.0");
	}
	
	@Test
	public void test2() {
			String[] test = {"6","2"};
			MOD mod = new MOD();
			assertEquals(mod.executable(test), "0.0");
	}
	
	@Test
	public void test3() {
		String[] test = {"5.4","2"};
		MOD mod = new MOD();
		assertEquals(mod.executable(test), "1.4000000000000004");
	}
	
	@Test
	public void test4() {
		String[] test = {"14","3.465"};
		MOD mod = new MOD();
		assertEquals(mod.executable(test), "0.14000000000000057");
	}
	
	@Test
	public void test5() {
		String[] test = {"1","5"};
		MOD mod = new MOD();
		assertEquals(mod.executable(test), "1.0");
	}
	
	@Test
	public void test6(){
		String[] test = {"0", "1"};
		MOD mod = new MOD();
		assertEquals(mod.executable(test), "Error: Het getal dat moet gedeeld worden is 0");
	}
	
}
