package Formules;

import static org.junit.Assert.*;

import org.junit.Test;

public class ROUNDUPTest {

	@Test
	public void test1() {
		String[] test = {"2.4533254","3"};
		ROUNDUP r = new ROUNDUP();
		assertEquals(r.executable(test),"2.454");
	}
	
	//negative getal
	@Test
	public void test2() {
		String[] test = {"-2.4533254","3"};
		ROUNDUP r = new ROUNDUP();
		assertEquals(r.executable(test),"-2.454");
	}
	
	@Test
	public void test3() {
		String[] test = {"10.541","2"};
		ROUNDUP r = new ROUNDUP();
		assertEquals(r.executable(test),"10.55");
	}
	
	@Test
	public void test4() {
		String[] test = {"2.45234","hamza"};
		ROUNDUP r = new ROUNDUP();
		assertEquals(r.executable(test),"Error: Not a number!");
	}
	
	@Test
	public void test5() {
		String[] test = {"6","3"};
		ROUNDUP r = new ROUNDUP();
		assertEquals(r.executable(test),"6");
	}
	
	
}
