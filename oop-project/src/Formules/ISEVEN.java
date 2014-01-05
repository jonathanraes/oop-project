package Formules;


public class ISEVEN extends Formule {

	public String executable(String[] a) {
		double waarde;
		try{
			waarde = Double.parseDouble(a[0]);
		}catch(NumberFormatException e){
			return "#VALUE!";
		}
		if(waarde >= 0){
			if(waarde % 2 >= 1)
				return "FALSE";
			else
				return "TRUE";
		}else{
			if(waarde % 2 > -1)
				return "TRUE";
			else
				return "FALSE";	
		}
	}

}
