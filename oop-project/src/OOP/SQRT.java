package OOP;

public class SQRT extends Formule  {
	public String executable(String[] a) {
		/**
		 * Deze methode wordt gebruikt om de wortel van een getal te berekenen. (Square Root)
		 */
		double number = Double.parseDouble(a[0]); 
		
		return "" + Math.sqrt(number) + "";
	}
}
