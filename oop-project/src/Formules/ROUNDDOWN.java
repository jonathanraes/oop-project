package Formules;

/**
 * Klasse ROUNDDOWN: Rondt een getal naar beneden af, naar nul.
 *
 */
public class ROUNDDOWN extends Formule {

	public String executable(String[] a) {
		/**
		 * ROUNDDOWN(getal;aantal-decimalen)
		 * Als aantal-decimalen groter dan 0 (nul) is, wordt getal naar beneden afgerond op het opgegeven aantal decimalen
		 * Als aantal_decimalen gelijk aan 0 is, wordt getal naar beneden afgerond op het dichtstbijzijnde gehele getal.
		 * Als aantal-decimalen kleiner dan 0 is, wordt getal naar beneden afgerond op tientallen (-1), honderdtallen (-2), enzo.
		 * 
		 */
		
		// Er wordt als eerst het getal dat moet afgerond worden toegekend aan
		// de String waarde
		String waarde = a[0];

		// Daarna wordt er gechekt of beide elementen in de String[] a de juiste
		// getallen zijn
		// Tegelijkertijd wordt het aantal decimalen om naar af te ronden
		// toegekend aan dec
		int dec;
		try {
			Double.parseDouble(a[0]);
			dec = Integer.parseInt(a[1]);
		} catch (NumberFormatException NFS) {
			return "Error1: Not a number!";
		}

		// Wij maken dan een nieuwe String[] om het getal die afgerond moet
		// worden te splitten en op te slaan
		String[] temp;
		try {
			// Hier wordt het getal gesplit bij de komma
			temp = waarde.split("[.]");
		} catch (NumberFormatException NFS) {
			return "Error2: Not a number!";
		}
			
		
		
		
		
		// Als dec(aantal cijfers achter de komma) groter dan 1 is..
		if (dec > 0) {
			// Er wordt gechekt of er daadwerkelijk 2 elementen zitten in de
			// String[] temp
			// Oftwel of er een komma in het getal zat die afgerond moest worden
			if (temp.length == 2) {
			
				/*-----------------------------------*/
				// in geval dat er minder cijfers achter de getallen staan dan er moet worden afgerond!
				if(dec>temp[1].length()){
					return a[0];
				} else {
				/*-----------------------------------*/
				
				
				// er wordt dan bij de deel van het getal die achter de komma
				// staat verder een substring
				// gemaakt om alleen aantal cijfers achter de komma te houden
				// die worden gevraagd
				temp[1] = temp[1].substring(0, dec);
				int e;
				try {
					e = Integer.parseInt(temp[1]);

				} catch (NumberFormatException NFE) {
					return "Error3: Not a number!";
				}

				// Er wordt weer van de losse delen een getal gemaakt in een
				// vorm van een string.
				// Deze deel wordt dan geretourneerd
				return temp[0] + "." + e;}
			} else {
				// Als de String[] temp geen 2 elementen bevat, dan betekent het
				// dat er geen komma in het getal zat
				// Dus het is een gehele getal en die mag geretourneerd worden
				// zonder verandering
				return temp[0];
			}

		} else if (dec == 0) {
			// Al het aantal cijfers die achter komma mogen staan 0 is, wordt
			// het alleen de deel van de String geretourneerd die achter de
			// komma was
			return temp[0];
		} else {
			// Hier begint de deel als dec negatief is
			// We halen de stukje van het getal voor de komma en verwijder het
			// aantal cijfers die negatief voor de komma mogen.

			// We kijken eerst hoeveel cijfers over mogen blijven
			if (-dec < temp[0].length()) {
				int number = temp[0].length() + dec;
				String answer = temp[0].substring(0, number);

				// De rest van de cijfers voor de komma gaan we veranderen in
				// een 0
				for (int i = 0; i < -dec; i++) {
					answer = answer + "0";
				}

				return answer;
			} else {
				// als de linker deel van de komma minder cijfers bevat dan dat er negatief moet afgerond worden wordt een 0 geretourneerd!
				// Bijv. ROUNDDOWN(123.23 , -6) ---> 0
				return "" + 0;
			}
		}
	}
}