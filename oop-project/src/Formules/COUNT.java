package Formules;
/**
 * COUNT klasse. Hier wordt geteld hoeveel integers/doubles in de geselecteerde cellen zitten. 
 * Dit wordt gedaan door de waardes van de cellen om te zetten in Strings en daarna de Strings toe te voegen aan de String array. 
 * Hieruit wordt gekeken of de Strings te parsen zijn tot een Double. Zo niet dat is het een echte String en moet deze dus niet meegeteld worden.
 * 
 */

public class COUNT extends Formule {

	/**
	 * Hier wordt per waarde afgegaan of het tot een double geparsed kan worden, zo ja wordt er 1 bij de counter opgeteld. Uiteindelijk wordt de counter gereturned als String
	 * @param String[] waardes: String array met de waardes van de cellen
	 * @return String: Hierin wordt het aantal int geparsed tot een String en gereturned 
	 */
	public String executable (String[] waardes) {
		// return waarde van formule COUNT wordt geinitializeerd op 0
		int countnumbers = 0;
		/* Nu worden alle ingevoerde waarden geparsed. Als de parseDouble werkt, en er dus geen NumberFormatException ontstaat,
		 * betekent het dat de geparsde waarde een nummer is, wat leidt tot het optellen van een waarde aan countnumbers. Lukt de parse niet,
		 * dan wordt de NumberFormatException opgevangen. Omdat we nu weten dat het geen getal is, hoeven we ook niets meer met deze waarde te doen.
		 * Het parsen van een lege String levert ook een NumberFormatException op, dus wat we nu hebben telt lege cellen niet mee.
		 */
		for(int i=0; i<waardes.length; i++){
			try{
				Double.parseDouble(waardes[i]);
				countnumbers = countnumbers + 1;
			}catch(NumberFormatException e){
			}
		}
		return "" + countnumbers;
	}
}