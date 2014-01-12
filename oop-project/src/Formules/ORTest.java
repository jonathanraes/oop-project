package Formules;

import static org.junit.Assert.*;

import org.junit.Test;

public class ORTest {

	@Test
	public void test1() {
		String[] test = {"4<6","3>1","2=2"};
		OR or = new OR();
		System.out.println(or.executable(test));
		assertEquals(or.executable(test),"false");
	}
}
