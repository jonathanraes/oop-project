package Formules;

/**
 * Test klasse om makkelijk de formules zelf te testen
 * @author Maiko
 *
 */
public class FormulesTester {
	public static void main(String[]args){
		int testInt = 10;
		String testSt = "hoi";
		double testDouble = 10.54;
		String[] test = {"3","",null + "","","1","10cvb"};
		COUNTA ave = new COUNTA();
		System.out.println(ave.executable(test));
		System.out.println(""+ null);
		System.out.println(testSt);
	}
}
