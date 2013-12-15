package OOP;

public class ISEVEN extends Formule {

	public String executable(String[] a) {
		double waarde;
		try{
			waarde = Double.parseDouble(a[0]);
		}catch(NumberFormatException e){
			return "#VALUE!";
		}
		if(waarde >= 0){
			
			for(int i = 0; waarde >= 2; i++){
				waarde = waarde - 2;
			}
		}if(waarde<0){
			
		}
		
		if(waarde == 0)
			return "TRUE";
		else
			return "FALSE";
	}

}
