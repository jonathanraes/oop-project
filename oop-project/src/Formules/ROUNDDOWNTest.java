package Formules;

import static org.junit.Assert.*;

import org.junit.Test;

public class ROUNDDOWNTest {

	@Test
	public void test() {
		String[] test = {"2.4533254","3"};
		ROUNDDOWN r = new ROUNDDOWN();
		assertEquals(r.executable(test),"2.453");
	}

}
