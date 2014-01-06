package Formules;
	/**
	 * MOD Klasse: Deze klasse wordt gebruikt om een speciale soort berekening te maken
	 * Hiermee wordt gekeken tot hoe ver is de eerste getal deelbaar door het tweede getal
	 * Als het getal niet verder deelbaar is, wordt de restant geretourneerd.
	 */

public class MOD extends Formule{
	/**
 	* Deze methode retourneert de overige gebeleven getal terug na het delen van een getal.
 	* @param String[] waardes
 	* Bijv:  MOD(5,2)=1
 	* Als het te delen getal 0 is, retourneert deze methode een error.
 	*/
	public String executable(String[] a) {
		// Wij parsen eerst de parameters voor deze method.
		// Het eerst getal wordt gedeeld door de tweede
		double number; 
		double divisor; 
		try{
			number= Double.parseDouble(a[0]);
			divisor= Double.parseDouble(a[1]);
		}catch(NumberFormatException e){
			return "Error: parseDouble bij MOD!";
		}
		
		//Wij kijken nu eerst of het te delen getal niet 0 is.
		//Als het getal 0 is geeft retourneert methode een error.
		if(number!=0){
			return ""+ number%divisor;
		}else{
			return"Error: Het getal dat moet gedeeld worden is 0";
		}
	}	
}
