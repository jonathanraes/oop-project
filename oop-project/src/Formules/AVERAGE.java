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
		int counter = 0;
		//for loop waarin wordt gekeken of het element een double of int is. Als dit zo is dan wordt die bij het totaal opgeteld. Zo niet wordt er niks gereturned.
		for(int i=0; i < waardes.length ;i++){
			try{double parse = Double.parseDouble(waardes[i]);
			totaal = totaal + parse;
			counter = counter + 1;
			}catch(NumberFormatException e){
			}
		}
		//als laatste wordt het totaal gedeeld door de lengte van a
		return totaal/counter + ""; 
	}
}