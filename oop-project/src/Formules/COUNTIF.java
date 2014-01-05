package Formules;
/**
 * COUNTIF klasse. Hierin wordt de formule COUNTIF uitgevoerd. COUNTIF telt het aantal cellen in de
 * geselecteerde reeks aan cellen die voldoen aan een opgegeven criteria door de gebruiker. Dit wordt gedaan
 * in de vorm van een expressie. Bijv: "=32", ">32", "apples", etc.
 * 
**/
public class COUNTIF extends Formule{
/**
 * executable, waar de inhoudelijk werking wordt uitgevoerd
 * @param String[] waardes: De String array met de waardes van de geselecteerde cellen.
 * @return String met het aantal cellen die voldoen aan de gespecificeerde criteria.
 */
	public String executable(String[] a) {
			int countnumber = 0;
			// a[0] is expressie die de volgende structuur heeft: operator(=/>/</<=/>=/<>) en dan cell/getal of String.
			String expressie = a[0];
			String waarde;
			String operator;
			if(expressie.contains("<>")){
				waarde = expressie.substring(2, expressie.length());
				operator = "<>";
				
			}else if(expressie.contains("<=")){
				waarde = expressie.substring(2, expressie.length());
				operator = "<=";
				
			}else if(expressie.contains(">=")){
				waarde = expressie.substring(2, expressie.length());
				operator = ">=";
				
			}else if(expressie.contains(">")){
				waarde = expressie.substring(1, expressie.length());
				operator = ">";
				
			}else if(expressie.contains("<")){
				waarde = expressie.substring(1, expressie.length());
				operator = "<";
				
			}else if(expressie.contains("=")){
				waarde = expressie.substring(1, expressie.length());
				operator = "=";
			}else
				return "NO VALID LOGICAL EXPRESSION";
			
			try{
				// Eerst wordt gekeken of de variabele waarde (de waarde uit de logische expressie) een getal is.
				double waardegetal = Double.parseDouble(waarde);
				if(operator.equals("<>")){
					for(int i=1; i<a.length;i++){
						try{
							if(Double.parseDouble(a[i]) != waardegetal)
								countnumber++;
						}catch(NumberFormatException NFE2){
						}
					}
					
				}else if(operator.equals("<=")){
					for(int i=1; i<a.length;i++){
						try{
							if(Double.parseDouble(a[i]) <= waardegetal)
								countnumber++;
						}catch(NumberFormatException NFE2){
						}
					}
					
				}else if(operator.equals(">=")){
					for(int i=1; i<a.length;i++){
						try{
							if(Double.parseDouble(a[i]) >= waardegetal)
								countnumber++;
						}catch(NumberFormatException NFE2){
						}
					}
					
				}else if(operator.equals(">")){
					for(int i=1; i<a.length;i++){
						try{
							if(Double.parseDouble(a[i]) > waardegetal)
								countnumber++;
						}catch(NumberFormatException NFE2){
						}
					}
					
				}else if(operator.equals("<")){
					for(int i=1; i<a.length;i++){
						try{
							if(Double.parseDouble(a[i]) < waardegetal)
								countnumber++;
						}catch(NumberFormatException NFE2){
						}
					}
					
				}else if(operator.equals("=")){
					for(int i=1; i<a.length;i++){
						try{
							if(Double.parseDouble(a[i]) == waardegetal)
								countnumber++;
						}catch(NumberFormatException NFE2){
						}
					}
				}
				
			}catch(NumberFormatException NFE){
				if(waarde.matches("[a-zA-Z]+[1-99]")){
					String cel = null; // = getcel(waarde) ofzo. <- Waarde ophalen uit cel.
					for(int i=1;i<a.length;i++){
						if(a[i].equalsIgnoreCase(cel))
							countnumber++;
					}
				}else{
					for(int i=1; i<a.length; i++){
						if(a[i].equalsIgnoreCase(waarde))
							countnumber++;
					}
				}
			}
			return "" + countnumber + "";
	}

}
