package Formules;

public class SQRT extends Formule  {
	
	public String executable(String[] a) {
		/**
		 * Deze methode wordt gebruikt om de wortel van een getal te berekenen. (Square Root)
		 */
		
		double number;
		try{
		number = Double.parseDouble(a[0]); 
		}catch(NumberFormatException e){
			return "Error: parseDouble bij SQRT!";
		}
		
		if(number>=0){		
		return "" + Math.sqrt(number) + "";
		}else{
			return"Error: Het getal waarvan de wortel moet berekend worden is negatief!";
		}
	}
}
