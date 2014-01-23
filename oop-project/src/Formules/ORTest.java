package Formules;

import static org.junit.Assert.*;

import org.junit.Test;

public class ORTest {

	@Test
	public void test1() {
		String[] test = {"4>6","","","3<1","","","2=2","",""};
		OR or = new OR();
		assertEquals(or.executable(test),"TRUE");
	}
	
	
	@Test
	public void test2() {
		String[] test = {"A1=A4","2","1","A3<A1","2","1","A2=2","2",""};
		OR or = new OR();
		System.out.println(or.executable(test));
		assertEquals(or.executable(test),"TRUE");
	}
	
	@Test
	public void test3() {
		String[] test = {"A4>6","10","","3<1","","","2<2","",""};
		OR or = new OR();
		System.out.println(or.executable(test));
		assertEquals(or.executable(test),"TRUE");
	}
	
	
	@Test
	public void test4() {
		String[] test = {"hello>1","","","A1>1","4","","4>5","",""};
		OR or = new OR();
		System.out.println(or.executable(test));
		assertEquals(or.executable(test),"TRUE");
	}
	
	@Test
	public void test6() {
		String[] test = {"A4>6","HOI","","3>1","","","2=2","",""};
		OR or = new OR();
		System.out.println(or.executable(test));
		assertEquals(or.executable(test),"TRUE");
	}
	
	@Test
	public void test7() {
		String[] test = {"A11>A2","12","2","3<1","","","5<2","",""};
		OR or = new OR();
		System.out.println(or.executable(test));
		assertEquals(or.executable(test),"TRUE");
	}
	
	@Test
	public void test8() {
		String[] test = {"A4>A6","1","1","3<1","","","A2=A1","2","2"};
		OR or = new OR();
		System.out.println(or.executable(test));
		assertEquals(or.executable(test),"TRUE");
	}
	
	@Test
	public void test9() {
		String[] test = {"4>=6","","","3<=1","","","2>=1","",""};
		OR or = new OR();
		System.out.println(or.executable(test));
		assertEquals(or.executable(test),"TRUE");
	}
	
	@Test
	public void test10() {
		String[] test = {"4=6","","","3=1","","","2=1","",""};
		OR or = new OR();
		System.out.println(or.executable(test));
		assertEquals(or.executable(test),"FALSE");
	}
	
	@Test
	public void test11() {
		String[] test = {"A4>=G6","8","12","A3=V1","1","3","A2<=1","4",""};
		OR or = new OR();
		System.out.println(or.executable(test));
		assertEquals(or.executable(test),"FALSE");
	}
	
	
}
