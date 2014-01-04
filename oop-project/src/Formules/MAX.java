package Formules;
import java.util.*;

/**
 * MAX klasse. Hier wordt van de geselecteerde waardes het grootste getal genomen en gereturnt.
 */
public class MAX extends Formule {
	/**
	 * Hier wordt gecontroleerd welke binnenkomende waardes getallen zijn en van de getallen wordt het grootste getal genomen.
	 * @param String[] waardes: String array met de waardes van de cellen
	 * @return String: Hierin wordt het grootste getal teruggegeven.
	 */
	public String executable(String[] a) {
		ArrayList<Double> waardes = new ArrayList<Double>();
		/*  
		 * 	In deze for-loop wordt gekeken of elke waarde in de binnenkomende StringLijst een getal is. 
		 *	Als het een getal is, wordt het toegevoegd aan de waardes ArrayList<Double>. Als het niet een getal is,
		 *  wordt er niets mee gedaan. 
		**/
		for(int i=0; i<a.length; i++){
			try{
				double parse = Double.parseDouble(a[i]);
				waardes.add(parse);
			}catch(NumberFormatException e){
				//waardes.add(0.0); <- weggehaald en gewoon niets alten gebeuren, omdat indien er alleen negatieve getallen zijn, de formule 0.0 returnt. *
			}	
		}
		// In plaats daarvan wordt er hier gekeken of de ArrayList leeg is, zo ja, dan wordt 0 gereturnt.
		if(waardes.isEmpty()){
			return "" + 0.0 + "";
		}else{
			/* Hier wordt per waarde uit de ArrayList gecontroleerd of het groter is dan het opgegeven getal max. Zo ja, dan wordt dat getal de max.
			 * Op het einde houd je dan het grootste getal over uit de reeks.
			 */
			double max = waardes.get(0);
			for(int i = 1; i < waardes.size(); i++){
				if(waardes.get(i) > max)
					max = waardes.get(i);
			}
			return "" + max + "";
		}
	}
	
}
