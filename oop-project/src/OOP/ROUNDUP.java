package OOP;

public class ROUNDUP extends Formule {
	
	public String executable(String[] a) {
		/**
		 * Deze methode rondt het getal af naar boven.
		 * De tweede parameter geeft aan hoeveel cijfers na de komma mogen blijven en de rest van de cijfers worden weg gelaten.
		 */
		double number = Double.parseDouble(a[0]); 
		double rest= number;
		
		for(int i = 0; rest > 1.0; i++){
			rest = rest - 1;	
			}
		
		double result = number-rest+1;
		return "" + result + "";

	}
}