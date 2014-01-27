package Tests;
/**
 * Test case van COUNT
 * @author Maiko
 */
import static org.junit.Assert.*;

import org.junit.Test;

import Formules.COUNT;

public class COUNTEST {

		//test met 3 identieke int
		@Test
		public void test1() {
			String[] test1 = {"10","10","10"};
			COUNT count = new COUNT();
			assertEquals(count.executable(test1),"3");
		}
		
		//test met 3 verschillende int
		@Test
		public void test2() {
			String[] test2 = {"35","22","17"};
			COUNT count = new COUNT();
			assertEquals(count.executable(test2),"3");
		}
		
		//test met 7 verschillende int
		@Test
		public void test3() {
			String[] test3 = {"35","22","17","2","55","36","98"};
			COUNT count = new COUNT();
			assertEquals(count.executable(test3),"7");
		}
		
		//test met 3 waardes waarvan één een string is dus de uitkomst is 2
		@Test
		public void test4() {
			String[] test4 = {"doet het niet","22","17"};
			COUNT count = new COUNT();
			assertEquals(count.executable(test4),"2");
			
		}
		//test met 3 verschillende doubles
		@Test
		public void test5() {
			String[] test5 = {"22.111122251651","22.22213","256.5155"};
			COUNT count = new COUNT();
			assertEquals(count.executable(test5),"3");
		}
		
		//test met een 3 ints waarvan een samengestelde int
		@Test
		public void test6() {
			String[] test6 = {"25" + "2","22","17"};
			COUNT count = new COUNT();
			assertEquals(count.executable(test6),"3");
		}
		
		//test met een int die in de String[] wordt geparsed naar een String
		@Test
		public void test7() {
			int testInt = 10;
			String[] test7 = {"" + testInt,"22","17"};
			COUNT count = new COUNT();
			assertEquals(count.executable(test7),"3");
		}
		
		//test met een int die in de String[] wordt geparsed naar een String
		@Test
		public void test8() {
			int testInt = 10;
			String[] test8 = {"" + testInt,"22","t3st","l33t","17","32"+"abc"};
			COUNT count = new COUNT();
			assertEquals(count.executable(test8),"3");
		}
}
