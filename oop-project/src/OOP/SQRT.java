package OOP;

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
		
		return "" + Math.sqrt(number) + "";
	}
}
