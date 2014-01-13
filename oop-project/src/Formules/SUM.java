package Formules;
import java.util.ArrayList;
/**
 * 
 *SUM Klasse: Hiermee kan je de som van de waardes van cellen berekenen.
 */
public class SUM extends Formule{
	/**
	 * Deze methode stopt eerst alle waardes in een ArrayList
	 * Vervolgens worden de waarden van deze ArrayList opgesomd
	 * De resultaat wordt in een string gestopt en wordt retourneerd.
	 * 
	 * @param String[] waardes: De String array met de waardes van de geselecteerde cellen.
	 * @return String: Deze String bevat de resultaat van het som van alle getallen.
	 */
	public String executable(String[] a) {
		
		//Deze stap stopt alle waarden van in een ArrayList door eerst parsen naar Doubles.
		ArrayList<Double> numbers = new ArrayList<Double>();
		for(int i=0; i<a.length; i++){
			try{
				double parse = Double.parseDouble(a[i]);
				numbers.add(parse);
			}catch(NumberFormatException e){
			}	
		}
		
		//Deze stap berekent de som van alle waarden.
		double sum = numbers.get(0);
		for(int i = 1; i < numbers.size(); i++){
			sum = sum+numbers.get(i);
		}

	return "" + sum;
		
	}
}
