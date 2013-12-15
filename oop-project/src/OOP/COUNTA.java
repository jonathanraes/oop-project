package OOP;

public class COUNTA extends Formule {

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
		return "" + countnummer + "";
	}

}
