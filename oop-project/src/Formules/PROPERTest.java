package Formules;
/**
 * Testklasse voor de Klasse PROPER
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class PROPERTest {

	@Test
	public void test1() {
		String[] test = {"mIjn nAam is haMza" };
		PROPER proper = new PROPER();
		System.out.println(proper.executable(test));
		assertEquals(proper.executable(test), "Mijn Naam Is Hamza");
	}

	// Deze test kijkt of er geen error optreedt als er een getal ook in de string voorkomt
	@Test
	public void test2() {
		String[] test = {"eR KoMeN 50 nIeUwe aflevEringen" };
		PROPER proper = new PROPER();
		System.out.println(proper.executable(test));
		assertEquals(proper.executable(test), "Er Komen 50 Nieuwe Afleveringen");
	}
	
	
}
