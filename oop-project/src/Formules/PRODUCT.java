package Formules;
/**
 * Klasse PRODUCT: Hiermee kan je de product van een lijst van getallen nemen.
 */
import java.util.ArrayList;

public class PRODUCT extends Formule {
	
	/**
	 * Syntax
	 * =PRODUCT(A1:A10) ---> 30
	 * 
	 * @param String[] waardes: String array met de waardes van de cellen
	 * @return String: Hierin wordt de product teruggegeven.
	 */
	public String executable(String[] a) {
		// We maken een Arraylist<Double> 
		// Hierin halen we alle getallen die moeten vermenigvuldigd worden 
		ArrayList<Double> numbers = new ArrayList<Double>();
		
		for(int i=0; i<a.length; i++){
			try{
				//We parsen elke element en voegen het toe in de arraylist
				double parse = Double.parseDouble(a[i]);
				numbers.add(parse);
			}catch(NumberFormatException e){
				//Er mag niks anders erin komen behalve een getal! Anders krijg je deze error
				return "Error: parseDouble bij PRODUCT!";
			}	
		}
		
		// Met deze stap wordt het vermenigvuldigd en daarna wordt de antwoord geretourneerd
		double product = numbers.get(0);
		for(int i = 1; i < numbers.size(); i++){
			product = product*numbers.get(i);
		}

	return "" + product;	
	}
}
