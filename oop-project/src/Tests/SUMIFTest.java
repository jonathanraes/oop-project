package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Formules.SUMIF;

public class SUMIFTest {

	@Test
	public void test1() {
		String[] test = {">4","","","5","1","24.1","1.2"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "24.1");
	}
	@Test
	public void test2() {
		String[] test = {"<2","","","-1","1","-5","1.2"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "-3.8");
	}
	@Test
	public void test3() {
		String[] test = {"<>4","","","5","1","24.1","1.2"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "25.3");
	}
	@Test
	public void test4() {
		String[] test = {"<=4","","","5","1","24.1","1.2"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "1.2");
	}
	@Test
	public void test5() {
		String[] test = {">=4","","","5","1","24.1","1.2"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "24.1");
	}
	@Test
	public void test6() {
		String[] test = {"=5","","","5","1","5","2","24.1","1.2","123","4.12"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "147.1");
	}
	@Test
	public void test7() {
		String[] test = {"askd4","","","5","1","24.1","1.2"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "NO VALID LOGICAL EXPRESSION");
	}
	@Test
	public void test8() {
		String[] test = {"askd4","","","5","1","24.1","1.2","123"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "RANGES DID NOT MATCH");
	}
	//------------------------------------------------------------------------
	@Test
	public void test11() {
		String[] test = {">4","","","5","1","asjdlkads","1.2"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "0.0");
	}
	@Test
	public void test12() {
		String[] test = {"<2","","","-1","1","3", "-5","hoi1.2","??"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "-5.0");
	}
	@Test
	public void test13() {
		String[] test = {"<>4","","","5","4","1","hue24.1","3","1.2"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "1.2");
	}
	@Test
	public void test14() {
		String[] test = {"<=4","","","5","1","24eneenhaalf","das"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "0.0");
	}
	@Test
	public void test15() {
		String[] test = {">=4","","","123","1","d24.1","1komma2"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "0.0");
	}
	@Test
	public void test16() {
		String[] test = {"=5","","","5","1","5","2","d24.1","1.2","123","4.12"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "123.0");
	}
	@Test
	public void test17() {
		String[] test = {"askd4","","","5","1","24.1","1.2"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "NO VALID LOGICAL EXPRESSION");
	}
	@Test
	public void test18() {
		String[] test = {"askd4","","","5","1","24.1","1.2","123"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "RANGES DID NOT MATCH");
	}
	//----------------------------------------------------------------
	@Test
	public void test21() {
		String[] test = {">A2","","4","5","1","asjdlkads","1.2"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "0.0");
	}
	@Test
	public void test22() {
		String[] test = {"<J18","","2","-1","1","3", "-5","hoi1.2","??"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "-5.0");
	}
	@Test
	public void test23() {
		String[] test = {"<>H83","","4","5","4","1","hue24.1","3","1.2"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "1.2");
	}
	@Test
	public void test24() {
		String[] test = {"<=G21","","4","5","1","24eneenhaalf","das"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "0.0");
	}
	@Test
	public void test25() {
		String[] test = {">=A41","","4","123","1","d24.1","1komma2"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "0.0");
	}
	@Test
	public void test26() {
		String[] test = {"=G34","","5","5","1","5","2","d24.1","1.2","123","4.12"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "123.0");
	}
	@Test
	public void test27() {
		String[] test = {"<=G21","","4","5","1","24eneenhaalf","1"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "1.0");
	}
	@Test
	public void test28() {
		String[] test = {">=A41","","4","123","1","24.1","1komma2"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "24.1");
	}
	@Test
	public void test29() {
		String[] test = {">A2","","4","5","1","1.2","asjdlkads"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "1.2");
	}
	//------------------------------------------------------------------------------
	@Test
	public void test30() {
		String[] test = {">Aasd","","","5","1","1.2","asjdlkads"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "0.0");
	}
	@Test
	public void test31() {
		String[] test = {"=Getal","","","getal","1","1.2","asjdlkads"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "1.2");
	}
	@Test
	public void test32() {
		String[] test = {"=Getal","","","getal","1","...","asjdlkads"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "0.0");
	}
	@Test
	public void test33() {
		String[] test = {"=G21","","getal","getal","1","getal1","getal","asjdlkads","2","da","2"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "2.0");
	}
	@Test
	public void test34() {
		String[] test = {">A21","","getal","getal","1","getal1","getal","asjdlkads","2","da","2"};
		SUMIF sumif = new SUMIF();
		assertEquals(sumif.executable(test), "0.0");
	}
}
