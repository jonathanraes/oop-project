package Formules;

import static org.junit.Assert.*;

import org.junit.Test;

public class IFTest {
// -------------------------- Wiskundige (on)gelijkheden --------------------------
	@Test
	public void test1() {
		String[] test = {"4<6","","","Dit is waar", "Dit is niet waar"};
		IF ifobject = new IF();
		assertEquals(ifobject.executable(test),"Dit is waar");
	}
	@Test
	public void test2(){
		String[] test = {"4>6","","", "FALSE", "TRUE"}; 
		IF ifobject = new IF();
		assertEquals(ifobject.executable(test),"TRUE");
	}
	@Test
	public void test3(){
		String[] test = {"2<>2","","", "TRUE", "fALSE"}; 
		IF ifobject = new IF();
		assertEquals(ifobject.executable(test),"fALSE");
	}
	@Test
	public void test4(){
		String[] test = {"1<=1","","", "1+1=2", "TRUE"}; 
		IF ifobject = new IF();
		assertEquals(ifobject.executable(test),"1+1=2");
	}
	@Test
	public void test5(){
		String[] test = {"4>=6","","", "hoi", "2^2=2"}; 
		IF ifobject = new IF();
		assertEquals(ifobject.executable(test),"2^2=2");
	}
	@Test
	public void test6(){
		String[] test = {"4=6","","", "FALSE", "1=2tog?"}; 
		IF ifobject = new IF();
		assertEquals(ifobject.executable(test),"1=2tog?");
	}
	@Test
	public void test8(){
		String[] test = {"4<>6","","", "Yay het klop!11!!", "TRUE"}; 
		IF ifobject = new IF();
		assertEquals(ifobject.executable(test),"Yay het klop!11!!");
	}
	@Test
	public void test9(){
		String[] test = {"281<=6","","", "6 is groter", "281 is groter"}; 
		IF ifobject = new IF();
		assertEquals(ifobject.executable(test),"281 is groter");
	}
	@Test
	public void test10(){
		String[] test = {"-1>=-2", "","","Mingetallen werken ook", "TRUE"}; 
		IF ifobject = new IF();
		assertEquals(ifobject.executable(test),"Mingetallen werken ook");
	}
	@Test
	public void test11(){
		String[] test = {"20<6","","", "FALSE", "TRUE"}; 
		IF ifobject = new IF();
		assertEquals(ifobject.executable(test),"TRUE");
	}
	@Test
	public void test12(){
		String[] test = {"20>6","","", "FALSE", "TRUE"}; 
		IF ifobject = new IF();
		assertEquals(ifobject.executable(test),"FALSE");
	}
	@Test
	public void test13(){
		String[] test = {"4=4","","", "EQUALS", "TRUE"}; 
		IF ifobject = new IF();
		assertEquals(ifobject.executable(test),"EQUALS");
	}
	
	// Zonder geldige voorwaarde.
	@Test
	public void test7(){
		String[] test = {"46","","", "FALSE", "TRUE"}; 
		IF ifobject = new IF();
		assertEquals(ifobject.executable(test),"NO LOGICAL EXPRESSION FOUND");
	}
	// 
	@Test
	public void test14(){
		String[] test = {"B16>D46","3","2", "FALSE", "TRUE"}; 
		IF ifobject = new IF();
		assertEquals(ifobject.executable(test),"FALSE");
	}
	// 
	@Test
	public void test15(){
		String[] test = {"B16>D46","2","3.2", "FALSE", "TRUE"}; 
		IF ifobject = new IF();
		assertEquals(ifobject.executable(test),"TRUE");
	}
	// 
	@Test
	public void test16(){
		String[] test = {"8.2>D46","","2", "FALSE", "TRUE"}; 
		IF ifobject = new IF();
		assertEquals(ifobject.executable(test),"FALSE");
	}
	// 
	@Test
	public void test17(){
		String[] test = {"B16>9","3","", "FALSE", "TRUE"}; 
		IF ifobject = new IF();
		assertEquals(ifobject.executable(test),"TRUE");
	}
	// 
	@Test
	public void test18(){
		String[] test = {"A29>0","3","", "FALSE", "TRUE"}; 
		IF ifobject = new IF();
		assertEquals(ifobject.executable(test),"FALSE");
	}
	// 
	@Test
	public void test19(){
		String[] test = {"B16>D46","3","hooi", "FALSE", "TRUE"}; 
		IF ifobject = new IF();
		assertEquals(ifobject.executable(test),"TRUE");
	}
	// 
	@Test
	public void test20(){
		String[] test = {"3>D46","","hoi", "FALSE", "TRUE"}; 
		IF ifobject = new IF();
		assertEquals(ifobject.executable(test),"TRUE");
	}
	// 
	@Test
	public void test21(){
		String[] test = {"String>D46","","2", "FALSE", "GEFAALD"}; 
		IF ifobject = new IF();
		assertEquals(ifobject.executable(test),"GEFAALD");
	}
	
}
