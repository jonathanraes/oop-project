package Formules;

import static org.junit.Assert.*;

import org.junit.Test;

public class ISLOGICALTest {
	// Wiskundige ongelijkheid die waar is. (TRUE)
	@Test
	public void test1() {
		String[] test1 = {"4>3"};
		ISLOGICAL islogical = new ISLOGICAL();
		assertEquals(islogical.executable(test1), "TRUE");
	}
	// Wiskundige ongelijkheid die onwaar is. (TRUE)
	@Test
	public void test2() {
		String[] test2 = {"86<-65"};
		ISLOGICAL islogical = new ISLOGICAL();
		assertEquals(islogical.executable(test2), "TRUE");
	}
	// Strings vergelijken. (FAlSE, werkt alleen op cellen of getallen).
	@Test
	public void test3() {
		String[] test3 = {"zij=hij"};
		ISLOGICAL islogical = new ISLOGICAL();
		assertEquals(islogical.executable(test3), "FALSE");
	}
	// Een getal. (TRUE)
	@Test
	public void test4() {
		String[] test4 = {"41223"};
		ISLOGICAL islogical = new ISLOGICAL();
		assertEquals(islogical.executable(test4), "FALSE");
	}
	// Vergelijking van getal met een cel. (TRUE)
	@Test
	public void test5() {
		String[] test5 = {"8<B5"};
		ISLOGICAL islogical = new ISLOGICAL();
		assertEquals(islogical.executable(test5), "TRUE");
	}
	// Cel met cel vergelijken, <= operator. (TRUE)
	@Test
	public void test6() {
		String[] test6 = {"C128<=H62"};
		ISLOGICAL islogical = new ISLOGICAL();
		assertEquals(islogical.executable(test6), "TRUE");
	}
	// Cel met getal vergelijken, <> operator. (TRUE)
	@Test
	public void test7() {
		String[] test7 = {"K23<>213"};
		ISLOGICAL islogical = new ISLOGICAL();
		assertEquals(islogical.executable(test7), "TRUE");
	}
	// Cel vergelijken met String, >= operator. (FALSE)
	@Test
	public void test8() {
		String[] test8 = {"K23>=hoi"};
		ISLOGICAL islogical = new ISLOGICAL();
		assertEquals(islogical.executable(test8), "FALSE");
	}
	// Met "false". (TRUE)
	@Test
	public void test9() {
		String[] test9 = {"false"};
		ISLOGICAL islogical = new ISLOGICAL();
		assertEquals(islogical.executable(test9), "TRUE");
	}
	// Met "TRUE". (TRUE)
	@Test
	public void test10() {
		String[] test10 = {"TRUE"};
		ISLOGICAL islogical = new ISLOGICAL();
		assertEquals(islogical.executable(test10), "TRUE");
	}

}
