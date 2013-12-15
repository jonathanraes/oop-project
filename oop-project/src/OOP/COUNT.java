package OOP;

public class COUNT extends Formule {

	public String executable (String[] a) {
		// return waarde van formule COUNT wordt geinitializeerd op 0
		int countnumbers = 0;
		/* Nu worden alle ingevoerde waarden geparsed. Als de parseDouble werkt, en er dus geen NumberFormatException ontstaat,
		 * betekent het dat de geparsde waarde een nummer is, wat leidt tot het optellen van een waarde aan countnumbers. Lukt de parse niet,
		 * dan wordt de NumberFormatException opgevangen. Omdat we nu weten dat het geen getal is, hoeven we ook niets meer met deze waarde te doen.
		 * Het parsen van een lege String levert ook een NumberFormatException op, dus wat we nu hebben telt lege cellen niet mee.
		 */
		for(int i=0; i<a.length; i++){
			try{
				Double.parseDouble(a[i]);
				countnumbers = countnumbers + 1;
			}catch(NumberFormatException e){
			}
		}
		return "" + countnumbers + "";
	}

}
