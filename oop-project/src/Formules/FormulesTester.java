package Formules;

/**
 * Test klasse om makkelijk de formules zelf te testen
 * @author Maiko
 *
 */
public class FormulesTester {
	public static void main(String[]args){
		int testInt = 10;
		double testDouble = 10.54;
		String[] test = {"" + (testInt + testDouble),"22","17"};
		AVERAGE ave = new AVERAGE();
		System.out.println(ave.executable(test));
	}
}
