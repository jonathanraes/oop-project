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
		String waarde= a[0];
	
		int dec = Integer.parseInt(a[1]);
		
		String[] temp = waarde.split("[.]");
		
		temp[1]=temp[1].substring(0, dec);
		
		return temp[0] + "." + temp[1];		

	}
}