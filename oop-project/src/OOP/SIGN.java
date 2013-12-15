package OOP;


public class SIGN extends Formule {

	public String executable(String[] a) {
		/**
		 * Als het getal positief is retourneert deze methode een 1
		 * Als het getal negatief is retourneert deze methode een -1
		 * Als het getal gelijk is aan 0 dan wordt er een 0 geretourneerd
		 */
		double number = Double.parseDouble(a[0]);
		int result=0;
		
		if(number>0){
			result=1;
		}else{
		if(number<0){
			result=-1;
			}
		}
		
		return "" + result + "";
	}
}
