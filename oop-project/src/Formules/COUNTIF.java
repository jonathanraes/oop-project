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
		// Een counter wordt geinitializeerd.	
		int countnumber = 0;
			// a[0] is expressie die de volgende structuur heeft: operator(=/>/</<=/>=/<>) en dan cell/getal of String.
			String expressie = a[0];
			
			// De verabelen waarde en operator worden hier alvast geinitizializeerd.
			String waarde;
			String operator;
			
			/* Hier wordt eerste gekeken naar of de logische expressie een operator heeft. Dit zijn <>, <=, >=, <, > en =.
			 * Als deze aanwezig zijn wordt afhankelijk van welke operator het is de substring methode opgeroepen om het deel uit de String te halen
			 * wat geen operator is: de waarde. Vervolgens wordt de operator die gevonden is toegewezen aan operator zodat we deze later kunnen gebruiken.
			 */
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
				
			// Indien er geen operator is gevonden, is het dus ook geen logische expressie. De formule returnt dan een error-booschap.
			}else
				return "NO VALID LOGICAL EXPRESSION";
			
			try{
				// Eerst wordt gekeken of de variabele waarde (de waarde uit de logische expressie) een getal is.
				double waardegetal = Double.parseDouble(waarde);
				/* Vervolgens wordt er gekeken naar welke operator er aanwezig was in de logische expressie. Afhankelijk daarvan wordt er een for-loop
				 * opgeroepen die de goede operator gebruikt in java om de binnenkomende waardes te vergelijken met de waarde die in de logische expressie staat.
				 * Indien die waarde een getal is, lukt de parse hierboven en bereiken we dit gedeelte. 
				 */
				if(operator.equals("<>")){
					for(int i=1; i<a.length;i++){
						/*	Elke waarde uit de binnenkomende selectie wordt geprobeerd te parsen als een getal en vervolgens vergeleken met het getal
						 * waardegetal afhankelijk van de operator die in het vorige deel is gevonden. Indien de parse niet lukt wordt de onstaande
						 * NumberFormatException opgevangen. In het catch-blok wordt niets gedaan omdat we alleen iets willen doen met getallen.
						 * Dit wordt herhaalt voor elke waarde in de binnenkomende selectie.
						 */
						try{
							if(Double.parseDouble(a[i]) != waardegetal)
								countnumber++;
						}catch(NumberFormatException NFE2){
						}
					}
				// Zelfde gedeelte als hierboven, maar dan voor operator <=
				}else if(operator.equals("<=")){
					for(int i=1; i<a.length;i++){
						try{
							if(Double.parseDouble(a[i]) <= waardegetal)
								countnumber++;
						}catch(NumberFormatException NFE2){
						}
					}
				// Zelfde gedeelte als hierboven, maar dan voor operator >=
				}else if(operator.equals(">=")){
					for(int i=1; i<a.length;i++){
						try{
							if(Double.parseDouble(a[i]) >= waardegetal)
								countnumber++;
						}catch(NumberFormatException NFE2){
						}
					}
				// Zelfde gedeelte als hierboven, maar dan voor operator >
				}else if(operator.equals(">")){
					for(int i=1; i<a.length;i++){
						try{
							if(Double.parseDouble(a[i]) > waardegetal)
								countnumber++;
						}catch(NumberFormatException NFE2){
						}
					}
				// Zelfde gedeelte als hierboven, maar dan voor operator <	
				}else if(operator.equals("<")){
					for(int i=1; i<a.length;i++){
						try{
							if(Double.parseDouble(a[i]) < waardegetal)
								countnumber++;
						}catch(NumberFormatException NFE2){
						}
					}
				// Zelfde gedeelte als hierboven, maar dan voor operator =
				}else if(operator.equals("=")){
					for(int i=1; i<a.length;i++){
						try{
							if(Double.parseDouble(a[i]) == waardegetal)
								countnumber++;
						}catch(NumberFormatException NFE2){
						}
					}
				}
			
			/*	Indien de parse in het bovenstaande try-block niet lukt, wat betekent dat het geen getal is, wordt de exceptie die opgegooid wordt
			 * hier opgevangen. Omdat het geen getal is, moet de waarde dus of een cel of een String zijn. 
			 */
			}catch(NumberFormatException NFE){
				/*	Eerst kijken we naar of het een cel is. Hiervoor gebruiken we de methode matches en kijken we door de regex [a-zA-Z]+[1-99]
				 * of de String bestaat uit een of meerdere letters (kleine of grote letters) met daarna een getal tussen 1 en 99. Deze structuur
				 * moet gelden over de hele String. Als het een cel is, wordt de inhoud van de cel
				 * 
				 */
				if(waarde.matches("[a-zA-Z]+[1-99]")){
					String cel = ; // = getcel(waarde) ofzo. <- Waarde ophalen uit cel.
					if(cel.matches("[0-9]+")){
						double celgetal = Double.parseDouble(cel);
						if(operator.equals("<>")){
							for(int i=1; i<a.length;i++){
								/*	Elke waarde uit de binnenkomende selectie wordt geprobeerd te parsen als een getal en vervolgens vergeleken met het getal
								 * celgetal afhankelijk van de operator die in het vorige deel is gevonden. Indien de parse niet lukt wordt de onstaande
								 * NumberFormatException opgevangen. In het catch-blok wordt niets gedaan omdat we alleen iets willen doen met getallen.
								 * Dit wordt herhaalt voor elke waarde in de binnenkomende selectie.
								 */
								try{
									if(Double.parseDouble(a[i]) != celgetal)
										countnumber++;
								}catch(NumberFormatException NFE2){
								}
							}
						// Zelfde gedeelte als hierboven, maar dan voor operator <=
						}else if(operator.equals("<=")){
							for(int i=1; i<a.length;i++){
								try{
									if(Double.parseDouble(a[i]) <= celgetal)
										countnumber++;
								}catch(NumberFormatException NFE2){
								}
							}
						// Zelfde gedeelte als hierboven, maar dan voor operator >=
						}else if(operator.equals(">=")){
							for(int i=1; i<a.length;i++){
								try{
									if(Double.parseDouble(a[i]) >= celgetal)
										countnumber++;
								}catch(NumberFormatException NFE2){
								}
							}
						// Zelfde gedeelte als hierboven, maar dan voor operator >
						}else if(operator.equals(">")){
							for(int i=1; i<a.length;i++){
								try{
									if(Double.parseDouble(a[i]) > celgetal)
										countnumber++;
								}catch(NumberFormatException NFE2){
								}
							}
						// Zelfde gedeelte als hierboven, maar dan voor operator <	
						}else if(operator.equals("<")){
							for(int i=1; i<a.length;i++){
								try{
									if(Double.parseDouble(a[i]) < celgetal)
										countnumber++;
								}catch(NumberFormatException NFE2){
								}
							}
						// Zelfde gedeelte als hierboven, maar dan voor operator =
						}else if(operator.equals("=")){
							for(int i=1; i<a.length;i++){
								try{
									if(Double.parseDouble(a[i]) == celgetal)
										countnumber++;
								}catch(NumberFormatException NFE2){
								}
							}
						}
					/*	Als de inhoud van de cel geen getal is, is het een String en moet het gewoon als een String, zonder te letten op hoofd-
					 * en kleine letters, vergeleken worden met alle waardes uit de binnenkomende selectie.
					 * 
					 */
					}else{
						for(int i=1;i<a.length;i++){
							if(a[i].equalsIgnoreCase(cel))
								countnumber++;
						}
					}
				/*	Als de waarde uit de logische expressie geen getal en geen cel is, moet het dus een String zijn. Hier vergelijken we zonder te letten op 
				 * hoofdletters en kleine letters of de inhoud van de String en de binnenkomende String hetzelfde zijn. Zo ja, dan wordt de counter verhoogd.
				 */
				}else{
					for(int i=1; i<a.length; i++){
						if(a[i].equalsIgnoreCase(waarde))
							countnumber++;
					}
				}
			}
			// Als laatste wordt dan de counter gereturnt als een String tussen aanhalingstekens.
			return "" + countnumber + "";
		}
}