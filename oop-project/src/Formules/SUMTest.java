package Formules;

import static org.junit.Assert.*;

import org.junit.Test;

public class SUMTest {

	/**
	 * Deze test kijkt of de methode een error geeft als een van de parameters geen getal is
	 * Hiermee de parser van deze methode ook testen 
	 */
	@Test
	public void test1() {
		String[] test = { "13583","354","This is not going to work!" };
		SUM sum = new SUM();
		assertEquals(sum.executable(test), "13937.0");
	}
	
	//Test met 3 geheel getallen
	@Test
	public void test2() {
		String[] test = { "3","4","3","325" };
		SUM sum = new SUM();
		System.out.println(sum.executable(test));
		assertEquals(sum.executable(test), "335.0");
	}
	
	//Test met decimaal getallen
	@Test
	public void test3() {
		String[] test = { "3","4.0","3.384","234","3" };
		SUM sum = new SUM();
		System.out.println(sum.executable(test));
		assertEquals(sum.executable(test), "247.38400000000001");
	}
	
	
	
	//Test met alleen negatieve getallen.
	@Test
	public void test4() {
		String[] test = { "-1","-4","-2","-8","-3" };
		SUM sum = new SUM();
		System.out.println(sum.executable(test));
		assertEquals(sum.executable(test), "-18.0");
	}
	
	
	//Test met negatieve en positieve getallen samen
	@Test
	public void test5() {
		String[] test = { "-33","4","-3" };
		SUM sum = new SUM();
		System.out.println(sum.executable(test));
		assertEquals(sum.executable(test), "-32.0");
	}
}
