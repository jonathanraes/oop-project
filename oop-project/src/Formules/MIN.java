package Formules;
import java.util.*;
/**
 * Klasse MIN: Wordt gebruikt om de minimale waarde van een verzameling van getallen te uitzoeken
 */


public class MIN extends Formule {
	/**
	 * Voorbeeld
	 * =PRODUCT(A1:A6)
	 * 
	 * @param String[] waardes: String array met de waardes van de cellen
	 * @return String: Hierin wordt de minimum waarde teruggegeven.
	 */
	public String executable(String[] a) {
		// We maken een Arraylist<Double> 
		// Hierin halen we alle getallen die moeten vermenigvuldigd worden
		ArrayList<Double> waardes = new ArrayList<Double>();
		for(int i=0; i<a.length; i++){
			try{
				double parse = Double.parseDouble(a[i]);
				waardes.add(parse);
			}catch(NumberFormatException e){
			}	
		}
		
		// Wij kijken met deze stap welke getal het kleinste is en dat wordt geretourneerd als de antwoord
		double min = waardes.get(0);
		for(int i = 1; i < waardes.size(); i++){
			if(waardes.get(i) < min)
				min = waardes.get(i);
		}
		return "" + min + "";
	}
	
}