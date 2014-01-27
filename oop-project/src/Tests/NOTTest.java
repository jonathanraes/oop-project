package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Formules.NOT;

public class NOTTest {

	@Test
	public void test1() {
		String[] test = {"4<6"};
		NOT not = new NOT();
		assertEquals(not.executable(test),"FALSE");
	}
	@Test
	public void test2(){
		String[] test = {"4>6"}; 
		NOT not = new NOT();
		assertEquals(not.executable(test),"TRUE");
	}
	@Test
	public void test3(){
		String[] test = {"2<>2"}; 
		NOT not = new NOT();
		assertEquals(not.executable(test),"TRUE");
	}
	@Test
	public void test4(){
		String[] test = {"1<=1"}; 
		NOT not = new NOT();
		assertEquals(not.executable(test),"FALSE");
	}
	@Test
	public void test5(){
		String[] test = {"4>=6"}; 
		NOT not = new NOT();
		assertEquals(not.executable(test),"TRUE");
	}
	@Test
	public void test6(){
		String[] test = {"4=6"}; 
		NOT not = new NOT();
		assertEquals(not.executable(test),"TRUE");
	}
	@Test
	public void test8(){
		String[] test = {"4<>6"}; 
		NOT not = new NOT();
		assertEquals(not.executable(test),"FALSE");
	}
	@Test
	public void test9(){
		String[] test = {"281<=6"}; 
		NOT not = new NOT();
		assertEquals(not.executable(test),"TRUE");
	}
	@Test
	public void test10(){
		String[] test = {"-1>=-2"}; 
		NOT not = new NOT();
		assertEquals(not.executable(test),"FALSE");
	}
	@Test
	public void test11(){
		String[] test = {"20<6"}; 
		NOT not = new NOT();
		assertEquals(not.executable(test),"TRUE");
	}
	@Test
	public void test12(){
		String[] test = {"20>6"}; 
		NOT not = new NOT();
		assertEquals(not.executable(test),"FALSE");
	}
	@Test
	public void test13(){
		String[] test = {"4=4","",""}; 
		NOT not = new NOT();
		assertEquals(not.executable(test),"FALSE");
	}
	
	// Zonder geldige voorwaarde.
	@Test
	public void test7(){
		String[] test = {"46"}; 
		NOT not = new NOT();
		assertEquals(not.executable(test),"NO LOGICAL EXPRESSION FOUND");
	}
	// 
	@Test
	public void test14(){
		String[] test = {"B16>D46","3","2"}; 
		NOT not = new NOT();
		assertEquals(not.executable(test),"FALSE");
	}
	// 
	@Test
	public void test15(){
		String[] test = {"B16>D46","2","3.2"}; 
		NOT not = new NOT();
		assertEquals(not.executable(test),"TRUE");
	}
	// 
	@Test
	public void test16(){
		String[] test = {"8.2>D46","","2"}; 
		NOT not = new NOT();
		assertEquals(not.executable(test),"FALSE");
	}
	// 
	@Test
	public void test17(){
		String[] test = {"B16>9","3",""}; 
		NOT not = new NOT();
		assertEquals(not.executable(test),"TRUE");
	}
	// 
	@Test
	public void test18(){
		String[] test = {"A29>0","3",""}; 
		NOT not = new NOT();
		assertEquals(not.executable(test),"FALSE");
	}
	// 
	@Test
	public void test19(){
		String[] test = {"B16>D46","3","hooi"}; 
		NOT not = new NOT();
		assertEquals(not.executable(test),"TRUE");
	}
	// 
	@Test
	public void test20(){
		String[] test = {"3>D46","","hoi"}; 
		NOT not = new NOT();
		assertEquals(not.executable(test),"TRUE");
	}
	// 
	@Test
	public void test21(){
		String[] test = {"String>D46","","2"}; 
		NOT not = new NOT();
		assertEquals(not.executable(test),"TRUE");
	}
	

}





