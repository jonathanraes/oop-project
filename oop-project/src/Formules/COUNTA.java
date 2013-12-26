package Formules;
/**
 * COUNTA klasse. Hierin wordt de formule COUNTA uitgevoerd. COUNTA telt het aantal cellen in de opgegeven selectie, die niet leeg zijn
 * Alle binnenkomende waardes in de String[] a wordt vergelijken met "" en null, om te kijken of het niet leeg is.
 * Indien het niet leeg is, en dus ongelijk aan "" en null, dan wordt het meegerekent met de counter.
 */

public class COUNTA extends Formule {
/**
 * executable, hierin wordt de inhoudelijk werking van COUNTA uitgevoerd
 * @param String[] waardes: De String array met de waardes van de geselecteerde cellen.
 * @return String met het aantal niet lege cellen in de selectie aan cellen.
 */
	public String executable(String[] a) {
		// Return waarde wordt geinitializeerd op 0
		int countnummer = 0;
		
		/* Vervolgens gaan we per waarde in de StringLijst of deze niet leeg is,
		*  Zo niet, dan wordt countnummer 1 opgehoogd.
		*/
		for(int i=0; i<a.length; i++){
			// Als de String in de StringLijst ongelijk aan null en niet leeg is wordt countnummer opgehoogd.
			if(a[i] != "" && a[i] != null){
				countnummer = countnummer + 1;
			}
		}
		return countnummer + "";
	}
}