package Formules;
import java.util.*;
import java.*;

public class ISLOGICAL extends Formule{

	public String executable(String[] a) {
		String waarde = a[0];
		/*try{
			Double.parseDouble(waarde);
			return "FALSE";
		}catch(NumberFormatException NFE){
		*/
			if(waarde.contains("<>")){
				String operator = "<>";
				int plvindex1 = waarde.indexOf("<");
				String deel1 = waarde.substring(0, plvindex1);
				String deel2 = waarde.substring(plvindex1+2, waarde.length());
				try{
					Double.parseDouble(deel1);
					Double.parseDouble(deel2);
					return "TRUE";
				}catch(NumberFormatException NFE){
					return "FALSE";
				}
			}else if(waarde.contains("<=")){
				
			}else if(waarde.contains(">=")){
				
			}else if(waarde.contains(">")){
				
			}else if(waarde.contains("<")){
				
			}else if(waarde.contains("=")){
				
			}else
				return "FALSE";
	}
	public String tweetekensoperatorscheider(String waarde, String operator){
		int plvindex1 = waarde.indexOf(operator.substring(0, 1));
		String deel1 = waarde.substring(0, plvindex1);
		String deel2 = waarde.substring(plvindex1+2, waarde.length());
		try{
			Double.parseDouble(deel1);
			if(celcontrole(deel2))
				return "TRUE";
			Double.parseDouble(deel2);
			return "TRUE";
		}catch(NumberFormatException NFE){
			try{
				if(celcontrole(deel1)){
					if(celcontrole(deel2))
						return "TRUE";
					Double.parseDouble(deel2);
					return "TRUE";
				}
				return "FALSE";
			}catch(NumberFormatException NFE2){
				return "FALSE";
			}
		
		}
		
	}
	public boolean celcontrole(String cel){
		if(Character.isLetter(cel.charAt(0)) && Character.isDigit(cel.charAt(cel.length()))){
			return true;
		}else
			return false;
	}

}
