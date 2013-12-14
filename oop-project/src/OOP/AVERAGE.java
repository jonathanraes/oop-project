package OOP;
import java.util.*;

public class AVERAGE extends Formule {

	public String executable(String[] a) {
		// Maak een ArrayList aan om de waardes in op te slaan
		ArrayList<Double> waardes = new ArrayList<Double>();
		
		/* Hier worden alle binnenkomende waardes uit de String[] a opgehaald en
		 * geparsed mbv een for-loop.
		 */
		for(int i=0; i < a.length ;i++){
			// double parser per String[] a element.
			// Vervolgens wordt aan de ArrayList waardes de geparsde doubles toegevoegd.
			waardes.add();
		}
		
		// Totaal wordt op 0 geinitializeerd
		double totaal = 0;
		// In deze for-loop worden de opgehaalde waardes bij elkaar ogpeteld tot een totaal
		for(int i = 0; i < a.length; i++){
			// Hier wordt uit waardes individueel de waardes opgehaald en opgeteld bij het totaal
			totaal = totaal + waardes.get(0);
		}
		// Als laatste word het totaal gedeelt door de lengte van de String[], wat het totale aantal is
		double average = totaal / a.length;
		return "" + average + "";
	}
	
}
