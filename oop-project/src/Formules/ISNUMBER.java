package Formules;
/**
 * ISNUMBER klasse. Hierin wordt de formule ISNUMBER uitgevoerd. ISNUMBER returnt TRUE of FALSE afhankelijk van of de ingevoerde waarde een getal is.
 */

public class ISNUMBER extends Formule {
	/**
	 * executable, hier wordt gekeken of de ingevoerde waarde een getal is.
	 * @param String[] waardes: De String array met de waardes van de geselecteerde cellen, hierin is alleen de eerste waarde relevant, omdat ISNUMBER op 1 waarde werkt.
	 * @return String met TRUE of FALSE afhankelijk van of de invoer een getal is of niet.
	 */
	public String executable(String[] a) {
		
		try{
			/* Probeert de eerste waarde in de ArrayList a([0]) te parsen als een dubbel.
			 Lukt de parse naar een double, dan return de formule "TRUE", omdat het lukken van de parse betekent dat het een getal is.
			*/
			Double.parseDouble(a[0]);
			return "TRUE";
		}catch(NumberFormatException NFE){
			/*
			 Als de parse niet lukt, is a[0] dus geen getal en wordt er een NumberFormatException opgegooid
			 In deze catch wordt deze opgevangen en returnt de formule "FALSE", omdat het geen getal is.
			 */
			return "FALSE";
		}
	}
}
