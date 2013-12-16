package OOP;


public class SIGN extends Formule {

	public String executable(String[] a) {
		/**
		 * Als het getal positief is retourneert deze methode een 1
		 * Als het getal negatief is retourneert deze methode een -1
		 * Als het getal gelijk is aan 0 dan wordt er een 0 geretourneerd
		 */
		
		double number;
		int result=0;
		
		try{	
		number = Double.parseDouble(a[0]);
		}catch(NumberFormatException e){
			return "Error: parseDouble bij SIGN!";
		}
		
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
