package Formules;

import static org.junit.Assert.*;

import org.junit.Test;

public class LOWERTest {
	// Stringlijst met één String bestaande uit één woord.
	@Test
	public void test1() {
		String[] test1 = {"Hallo"};
		LOWER lower = new LOWER();
		assertEquals(lower.executable(test1),"hallo");
	}
	// Stringlijst met een getal.
	@Test
	public void test2() {
		String[] test2 = {"42"};
		LOWER lower = new LOWER();
		assertEquals(lower.executable(test2),"42");
	}
	// Stringlijst met één String bestaande uit een zin met een naam.
	@Test
	public void test3() {
		String[] test3 = {"Wie is Lionel Messi?"};
		LOWER lower = new LOWER();
		assertEquals(lower.executable(test3),"wie is lionel messi?");
	}
	// Stringlijst met meerdere woorden.
	@Test
	public void test4() {
		String[] test4 = {"Dit", "Is","Voor","OOP-Project"};
		LOWER lower = new LOWER();
		assertEquals(lower.executable(test4),"dit");
	}
}
