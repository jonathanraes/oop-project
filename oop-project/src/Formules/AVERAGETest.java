package Formules;
/**
 * Junit test van AVERAGE
 * @author Maiko
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class AVERAGETest {
	//test met 3 identieke int
	@Test
	public void test1() {
		String[] test1 = {"10","10","10"};
		AVERAGE ave = new AVERAGE();
		assertEquals(ave.executable(test1),"10.0");
	}
	//test met 3 verschillende int waar een geheel getal uit komt
	@Test
	public void test2() {
		String[] test1 = {"10","100","1000"};
		AVERAGE ave = new AVERAGE();
		assertEquals(ave.executable(test1),"370.0");
	}
	//test met 3 verschillende int waar een komma getal uit komt
	@Test
	public void test3() {
		String[] test1 = {"35","22","17"};
		AVERAGE ave = new AVERAGE();
		assertEquals(ave.executable(test1),"24.666666666666668");
	}
	//test met 7 verschillende int waar een komma getal uit komt
	@Test
	public void test4() {
		String[] test1 = {"35","22","17","2","55","36","98"};
		AVERAGE ave = new AVERAGE();
		assertEquals(ave.executable(test1),"37.857142857142854");
	}
	//test met een string dat geen int of double is
	@Test
	public void test5() {
		String[] test1 = {"doet het niet","22","17"};
		AVERAGE ave = new AVERAGE();
		assertEquals(ave.executable(test1),"");
	}
	//test met 3 verschillende double waar een komma getal uit komt.
	@Test
	public void test6() {
		String[] test1 = {"22.111122251651","22.22213","256.5155"};
		AVERAGE ave = new AVERAGE();
		assertEquals(ave.executable(test1),"100.28291741721699");
	}
	
	//test met een 2 int strings achter elkaar. "25" + "2" wordt 252
	@Test
	public void test7() {
		String[] test1 = {"25" + "2","22","17"};
		AVERAGE ave = new AVERAGE();
		assertEquals(ave.executable(test1),"97.0");
	}
	
	//test met een int die in de String[] wordt geparsed naar een String
	@Test
	public void test8() {
		int testInt = 10;
		String[] test1 = {"" + testInt,"22","17"};
		AVERAGE ave = new AVERAGE();
		assertEquals(ave.executable(test1),"16.333333333333332");
	}
	
	//test met een int en double die in de String[] naar een String worden geparsed(eerst) en bijelkaar opgeteld, maar hier worden ook de int en double achterelkaar gezet tot 1010.54
	@Test
	public void test9a() {
		int testInt = 10;
		double testDouble = 10.54;
		String[] test1 = {"" + testInt + testDouble ,"22","17"};
		AVERAGE ave = new AVERAGE();
		assertEquals(ave.executable(test1),"349.84666666666664");
	}
	
	//test met een int en double die in de String[] naar een String worden geparsed en bijelkaar opgeteld, maar wordt eerst de sommatie uitgevoerd en dan pas de parse
		@Test
		public void test9b() {
			int testInt = 10;
			double testDouble = 10.54;
			String[] test1 = {testInt + testDouble + "","22","17"};
			AVERAGE ave = new AVERAGE();
			assertEquals(ave.executable(test1),"19.846666666666668");
		}
		
	//zelfde test als test9a maar nu met haakjes sommatie van de int en double. Hierin wordt wel eerst de sommatie van de int en double uitgevoerd en daarna pas geparsed tot String
	@Test
	public void test9c() {
		int testInt = 10;
		double testDouble = 10.54;
		String[] test1 = {"" + (testInt + testDouble),"22","17"};
		AVERAGE ave = new AVERAGE();
		assertEquals(ave.executable(test1),"19.846666666666668");
	}
}
