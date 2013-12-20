package Formules;
/**
 * AVERAGE klasse. Hierin wordt de formule average uitgevoerd. average neemt het gemiddelde getal van de opgegeven getallen.
 */
public class AVERAGE extends Formule {

	/**
	 * executable, hier wordt het gemiddelde berekend
	 * @param String[] waardes: De String array met de waardes van de geselecteerde cellen
	 * @return String met het gemiddelde van waardes
	 */
	public String executable(String[] waardes) {
		//totaal initialiseren
		double totaal = 0;
		//for loop waarin wordt gekeken of het element een double of int is. Als dit zo is dan wordt die bij het totaal opgeteld. Zo niet wordt er niks gereturned.
		for(int i=0; i < waardes.length ;i++){
			try{double parse = Double.parseDouble(waardes[i]);
			totaal = totaal + parse;			
			}
			catch(NumberFormatException e){
			}
		}
		//als laatste wordt het totaal gedeeld door de lengte van a
		return totaal/waardes.length + ""; 
	}
}

//Dit is de code om altijd het gemiddelde de geven dus ook als er een niet parseable element erin zit.

//package Formules;
//import java.util.*;
///**
// * AVERAGE klasse. Hierin wordt de formule average uitgevoerd. average neemt het gemiddelde getal van de opgegeven getallen.
// */
//public class AVERAGE extends Formule {
//	
//	/**
//	 * executable, dit is main methode waarin de submethodes worden opgeroepen.
//	 */
//	public String executable(String[] a) {
//		return "" + getAvarage(isDouble(a));
//	}
//	
//	public ArrayList<Double> isDouble(String[]a){
//		// Maak een ArrayList aan om de waardes in op te slaan
//				ArrayList<Double> waardes = new ArrayList<Double>();
//				
//				/* Hier worden alle binnenkomende waardes uit de String[] a opgehaald en
//				 * geparsed mbv een for-loop.
//				 */
//				for(int i=0; i < a.length ;i++){
//					try{double parse = Double.parseDouble(a[i]);
//					// Vervolgens wordt aan de ArrayList waardes de geparsde doubles toegevoegd.
//					waardes.add(parse);
//					}
//					catch(NumberFormatException e){
//					}
//				}
//				return waardes;
//	}
//	
//	public double getAvarage(ArrayList<Double> waardes){
//		// Totaal wordt op 0 geinitializeerd
//				double totaal = 0;
//				// In deze for-loop worden de opgehaalde waardes bij elkaar ogpeteld tot een totaal
//				for(int i = 0; i < waardes.size(); i++){
//					// Hier wordt uit waardes individueel de waardes opgehaald en opgeteld bij het totaal
//					totaal = totaal + waardes.get(i);
//				}
//				return totaal/waardes.size();
//	}	
//}

//Dit was de orginele code

//package Formules;
//import java.util.*;
///**
// * AVERAGE klasse. Hierin wordt de formule average uitgevoerd. average neemt het gemiddelde getal van de opgegeven getallen.
// */
//public class AVERAGE extends Formule {
//	
//	/**
//	 * executable, hier wordt het gemiddelde berekend
//	 */
//	public String executable(String[] a) {
//		// Maak een ArrayList aan om de waardes in op te slaan
//		ArrayList<Double> waardes = new ArrayList<Double>();
//		
//		/* Hier worden alle binnenkomende waardes uit de String[] a opgehaald en
//		 * geparsed mbv een for-loop.
//		 */
//		for(int i=0; i < a.length ;i++){
//			try{double parse = Double.parseDouble(a[i]);
//			// Vervolgens wordt aan de ArrayList waardes de geparsde doubles toegevoegd.
//			waardes.add(parse);
//			}
//			catch(NumberFormatException e){
//				return "";
//			}
//		}
//		System.out.println(waardes.toString());
//		
//		// Totaal wordt op 0 geinitializeerd
//		double totaal = 0;
//		// In deze for-loop worden de opgehaalde waardes bij elkaar ogpeteld tot een totaal
//		for(int i = 0; i < a.length; i++){
//			// Hier wordt uit waardes individueel de waardes opgehaald en opgeteld bij het totaal
//			totaal = totaal + waardes.get(i);
//		}
//		// Als laatste word het totaal gedeelt door de lengte van de String[], wat het totale aantal is
//		double average = totaal / a.length;
//		return "" + average + "";
//	}
//	
//}
