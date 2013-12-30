package Formules;
/**
 * ISLOGICAL klasse. Hier wordt gekeken naar of de ingevulde waarde een logische waarde bevat (waar of onwaar) en returnt TRUE of FALSE afhankelijk daarvan. 
 */
public class ISLOGICAL extends Formule{
	/**
	 * Hier wordt bekeken of er een operator in de String aanwezig is en dan wordt die meegegeven aan de methode operatorscheider().
	 * @param String[] waardes: String array met de waardes van de cellen
	 * @return String: Hierin wordt "TRUE" of "FALSE" teruggegeven.
	 */
	public String executable(String[] a) {
		// De eerste String in de a wordt toegewezen aan waarde, hiervan moeten we uitzoeken of het inhoudelijke een logische waarde bevat.
		String waarde = a[0];
		
			/* Alle 6 de logische operators zijn hieronder gedefinieerd, 3 tweetekens operators en 3 eentekens operators.
			 * Afhankelijk van welke operator aanwezig is in de String waarde wordt die operator meegegeven als parameter
			 * aan de methode operatorscheider(), die controleert of naast het bevatten van de operator, aan beide kanten wel
			 * geldige informatie staan zodat de hele String een logische expressie is. Hierbij moet er aan beide kanten
			 * een getal of een cel staan. De methode operatorscheider() returnt al een String met TRUE of FALSE, deze kan dus
			 * direct hieronder gereturnt worden voor de formule.
			 */
			if(waarde.contains("<>")){
				return operatorscheider(waarde, "<>");
			}else if(waarde.contains("<=")){
				return operatorscheider(waarde, "<=");
			}else if(waarde.contains(">=")){
				return operatorscheider(waarde, ">=");
			}else if(waarde.contains(">")){
				return operatorscheider(waarde, ">");
			}else if(waarde.contains("<")){
				return operatorscheider(waarde, "<");
			}else if(waarde.contains("=")){
				return operatorscheider(waarde, "=");
				
			// Naast het bevatten van een logische operator, return de formule ISLOGICAL ook TRUE indien waarde gelijk is aan "TRUE" of "FALSE".
			}else if(waarde.equalsIgnoreCase("true") || waarde.equalsIgnoreCase("false")){
				return "TRUE";
				
			/* Bovenstaande gevallen zijn alle gevallen waarin de formule ISLOGICAL TRUE kan returnen.
			 * In alle andere gevallen returnt ISLOGICAL FALSE. Hierbij gaat het om String waarin geen operators staan, op "TRUE" en
			 * "FALSE" na. Hierbij gaat het bijvoorbeeld om getallen.
			 */
			}else
				return "FALSE";
	}
	/**
	 * In operatorscheider() wordt gekeken naar of aan beide kanten van de operator wel geldige informatie staat waardoor de String een logische expressie is.
	 * @param waarde ingevoerde String, wordt meegegeven in executable().
	 * @param operator operator die in waarde aanwezig is, wordt meegegeven in executable()
	 * @return String returnt aan executable() TRUE of FALSE afhankelijk van de inhoud.
	 */
	public String operatorscheider(String waarde, String operator){
		// Linker-...
		String deel1;
		// ...en rechterdeel van de operator worden gedefinieerd.
		String deel2;
				
		 // Afhankelijk van de lengte van de operator (2 of 1), worden deel1 en deel2 met hun bijbehorende informatie opgevuld mbv de methode substring().
		if(operator.length() == 2){
			int plvindex1 = waarde.indexOf(operator.substring(0, 1));
			deel1 = waarde.substring(0, plvindex1);
			deel2 = waarde.substring(plvindex1+2, waarde.length());
		}else{
			int plvindex = waarde.indexOf(operator);
			deel1 = waarde.substring(0,plvindex);
			deel2 = waarde.substring(plvindex+1, waarde.length());
		}
		
		/*
		 * Hier worden deel1 en deel2 gecontroleerd of het geldige informatie is voor de String om een logische expressie te zijn/logische waarde
		 * te bevatten. Voor dit om waar te zijn, moeten zowel deel1 als deel2, een getal of een cel zijn. Het eerste wordt gecontroleerd met behulp 
		 * van een parseDouble, welke als niet lukt betekent dat het geen getal is. Het wel of niet zijn van een cel wordt gecontroleerd met behulp van
		 * de methode celcontrole(). Meer informatie over deze methode is hieronder te vinden.
		 */
		try{
			// Eerst wordt gekeken naar of deel1 een getal is, zo ja dan wordt het try-block vervolgd, zo niet dan wordt er een exception opgegooid die opgevangen wordt in het catch-blok.
			Double.parseDouble(deel1);
			
			
			/*  Als dit bereikt wordt betekent het dat deel1 geldige informatie is, namelijk een getal of een cel. Hier wordt dan geconctroleerd
			 *  of deel2 een cel is, indien waar dan zijn zowel deel1 als deel2 geldige informatie voor een logische expressie, dus returnt
			 *  de formule TRUE.
			 */
			if(celcontrole(deel2))
				return "TRUE";
			
			/*
			 * Indien deel2 geen cel is, wordt er gekeken of deel2 een getal is mbv parseDouble(). Indien de parse lukt en deel2 dus een getal is,
			 * gaat het try-blok verder en wordt er TRUE gereturnt door de formule, want deel1 en deel2 zijn beide geldige informatie.
			 * Indien 2 geen getal is, wordt er een exception opgegooid en opgevangen verderop.
			 */
			Double.parseDouble(deel2);
			return "TRUE";
			
		// Het catch blok dat de excepties opvangt indien deel1 geen getal is of indien deel1 een getal is maar deel2 niet.
		}catch(NumberFormatException NFE){
			try{
				// Eerst wordt gekeken naar of deel1 een cel is.
				if(celcontrole(deel1)){
					// Als deel1 een cel is, wordt gekeken naar of deel2 een cel is.
					if(celcontrole(deel2))
						// Als deel1 en deel2 beide cellen blijken te zijn, returnt de formule TRUE.
						return "TRUE";
					/*
					 * Indien deel2 geen cel blijkt te zijn, moet er gecontroleerd worden of deel2 geen getal is. Wederom met een parse.
					 * Indien de parse lukt zal de return statement bereikt worden en returnt de formule "TRUE".
					 */ 
					Double.parseDouble(deel2);
					return "TRUE";
				}
				// Indien deel1 geen cel blijkt te zijn, en ook geen getal, want daarom zitten we in dit catch-blok is de String geen logische expressie meer en dus wordt er "FALSE" gereturnt.
				return "FALSE";
			// Hier wordt de exception opgevangen die opgegooid wordt indien deel1 een cel is maar deel2 geen getal en geen cel.
			}catch(NumberFormatException NFE2){
				// Omdat deel2 geen cel en geen getal is, is de String geen logische expressie. De formule returnt dus "FALSE".
				return "FALSE";
			}
		}
		
	}
	
	/**
	 * De methode celcontrole() die controleerd of de meegegeven String wel een cel definieert.
	 * @param cel String die gecontroleerd moet worden.
	 * @return true of false boolean afhankelijk van of de inhoud van String cel een cel definieert.
	 */
	public boolean celcontrole(String cel){
		/* Controleert of de eerste character van de String een letter is en of de laatste character een getal is.
		 * Indien dit waar is returnt deze methode de boolean true, indien niet dan returnt de methode de boolean false.
		 */
		if(Character.isLetter(cel.charAt(0)) && Character.isDigit(cel.charAt(cel.length()))){
			return true;
		}else
			return false;
	}

}
