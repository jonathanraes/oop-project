package Formules;
import java.util.*;


public class MIN extends Formule {

	/**
	 * Deze methode wordt gebruikt om een minimale waarde uit te zoeken van een verzameling van getallen.
	 */
	
	public String executable(String[] a) {
		ArrayList<Double> waardes = new ArrayList<Double>();
		for(int i=0; i<a.length; i++){
			try{
				double parse = Double.parseDouble(a[i]);
				waardes.add(parse);
			}catch(NumberFormatException e){
			}	
		}
		double min = waardes.get(0);
		for(int i = 1; i < waardes.size(); i++){
			if(waardes.get(i) < min)
				min = waardes.get(i);
		}
		return "" + min + "";
	}
	
}