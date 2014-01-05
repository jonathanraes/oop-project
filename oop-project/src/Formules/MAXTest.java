package Formules;

import static org.junit.Assert.*;

import org.junit.Test;

public class MAXTest {
	// String[] met 3 getallen op volgorde.
	@Test
	public void test1() {
		String[] test1 = {"2","5","213"};
		MAX max = new MAX();
		assertEquals(max.executable(test1),"213.0");
	}
	// String[] met 5 negatieve getallen in willekeurige volgorde.
	@Test
	public void test2() {
		String[] test2 = {"-31.1","-3.26","-25", "-21.39", "-58"};
		MAX max = new MAX();
		assertEquals(max.executable(test2),"-3.26");
	}
	// String[] met 8 willekeurige getallen in willekeurige volgorde.
	@Test
	public void test3() {
		String[] test3 = {"-320.10","291.3", "394.1", "2","58", "85","416.62", "0324"};
		MAX max = new MAX();
		assertEquals(max.executable(test3),"416.62");
	}
	// String[] met 2 Strings bestaande uit letters en 2 getallen.
	@Test
	public void test4() {
		String[] test4 = {"5", "Hoi","25.5", "Dit is geen getal"};
		MAX max = new MAX();
		assertEquals(max.executable(test4),"25.5");
	}
	// String[] met een negatief getal en een String bestaande uit letters en een getal.
	@Test
	public void test5() {
		String[] test5 = {"-1", "is 5 een getal?"};
		MAX max = new MAX();
		assertEquals(max.executable(test5),"-1.0");
	}
	// String[] zonder getallen.
	@Test
	public void test6() {
		String[] test6 = {"Waar zijn", "De getallen?", "!!?!??!?!"};
		MAX max = new MAX();
		assertEquals(max.executable(test6),"0.0");
	}
	// String[] met meerdere String bestaande uit woorden, waaronder 1 een getal bevat. …Èn getal is er aanwezig op het einde.
	@Test
	public void test7() {
		String[] test7 = {"Een getal", "onder de 0", "is", "-85"};
		MAX max = new MAX();
		assertEquals(max.executable(test7),"-85.0");
	}
}
