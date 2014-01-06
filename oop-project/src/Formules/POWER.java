package Formules;
/**
 * POWER Klasse: Hiermee kan je de macht berekenen van getallen
 */

public class POWER extends Formule{
	/**
	 * Deze methode retourneert het resultaat die je krijgt als je de eerste parameter 
     * van deze methode tot de macht van de tweede parameter berekent.
     *  
	 * @param String[] waardes:  hierin zijn alleen de eerste 2 waardes relevant
	 * @return eerste getal tot de macht van het tweede getal
	 * Bijv: POWER(5,2) --> 25
	 */
	public String executable(String[] a) {
		// Wij parsen eerst de parameters voor deze method.
		// Het getal en de macht ervoor worden als double geparsd.
		double number; 
		double power; 
		try{
			number= Double.parseDouble(a[0]);
			power= Double.parseDouble(a[1]);
		}catch(NumberFormatException e){
			return "Error: parseDouble bij POWER!";
		}
	
		return""+ Math.pow(number, power);
	}
}