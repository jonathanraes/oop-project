package OOP;
import java.util.*;
import java.math.BigDecimal;

public class MEDIAN extends Formule {

	public String executable(String[] a) {
		ArrayList<Double> waardes = new ArrayList<Double>();
		for(int i=0; i<a.length; i++){
			try{
				waardes.add(Double.parseDouble(a[i]));
			}catch(NumberFormatException e){
			}
		}
		// Lengte van de ArrayList modulo 2, als er een restant van 0 overblijft, is het een geheel getal, anders oneven.
		if(waardes.size() % 2 == 0){
			int een = waardes.size() / 2;
			int twee = een - 1;
			return "" + ((waardes.get(een) + waardes.get(2))/2) + "";
		}else{
			return "" + waardes.get((waardes.size() - 1)/2) + "";
		}
	}
}
