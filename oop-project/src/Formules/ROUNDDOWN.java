package Formules;

public class ROUNDDOWN extends Formule {
	/**
	 * deze methode rondt het getal af naar beneden.
	 * De tweede parameter geeft aan hoeveel cijfers na de komma mogen blijven en de rest van de cijfers worden weg gelaten.
	 * De nieuwe getal wordt geretourneerd
	 */
	
	public String executable(String[] a) {
		/**
		 * 
		 */
		double number;
		try{
			number = Double.parseDouble(a[0]); 
		}catch(NumberFormatException e){
			return "Error: parseDouble bij ROUNDDOWN!";
		}
		
		double rest= number;
		
		for(int i = 0; rest > 1.0; i++){
			rest = rest - 1;	
			}
		
		double result = number-rest;
		return "" + result + "";

	}
}