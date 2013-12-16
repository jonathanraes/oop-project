package OOP;

import java.util.ArrayList;

public class PRODUCT extends Formule {
	
	public String executable(String[] a) {
		
		ArrayList<Double> numbers = new ArrayList<Double>();
		for(int i=0; i<a.length; i++){
			try{
				double parse = Double.parseDouble(a[i]);
				numbers.add(parse);
			}catch(NumberFormatException e){
				return "Error: parseDouble bij PRODUCT!";
			}	
		}
		
		double product = numbers.get(0);
		for(int i = 1; i < numbers.size(); i++){
			product = product*numbers.get(i);
		}

	return "" + product + "";	
	}
}
