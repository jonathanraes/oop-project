package OOP;
import java.util.*;


public class MAX extends Formule {

	public String executable(String[] a) {
		ArrayList<Double> waardes = new ArrayList<Double>();
		for(int i=0; i<a.length; i++){
			try{
				double parse = Double.parseDouble(a[i]);
				waardes.add(parse);
			}catch(NumberFormatException e){
				waardes.add(0.0);
			}	
		}
		double max = waardes.get(0);
		for(int i = 1; i < waardes.size(); i++){
			if(waardes.get(i) > max)
				max = waardes.get(i);
		}
		return "" + max + "";
	}
	
}
