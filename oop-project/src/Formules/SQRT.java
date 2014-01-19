package Formules;
/**
 * Klasse SQRT: wordt gebruikt om wortel te nemen van een getal.
 *
 */
public class SQRT extends Formule  {
	
	public String executable(String[] a) {
		/**
		 * Deze methode wordt gebruikt om de wortel van een getal te berekenen. (Square Root)
		 * Bijv. SQRT(25) = 5
		 * 
		 * @param String[] waardes: String array met de waarde waarvan wortel moet genomen worden
		 * @return String: Hierin wordt wortel van het getal teruggegeven.
		 */
		
		double number;
		try{
			// parsen naar double.
		number = Double.parseDouble(a[0]); 
		}catch(NumberFormatException e){
			return "Error: parseDouble bij SQRT!";
		}
		
		// Het waarde waarvan de wortel wordt genomen mag niet 0 zijn!
		if(number>=0){		
		return "" + Math.sqrt(number) + "";
		}else{
			return"Error: Het getal waarvan de wortel moet berekend worden is negatief!";
		}
	}
}
