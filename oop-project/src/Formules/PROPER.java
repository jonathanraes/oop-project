package Formules;
/**
 *
 *PROPER Klasse: Hier verandert van elke woord in een string de eerste letter naar een Uppercase 
 *en de rest naar Lowercase 
 */
public class PROPER extends Formule {
	/**
	 * Deze methode wordt gebruikt om een String te veranderen zodat elke
	 * eerste letter van een woord in de string een Uppercase wordt 
	 * en de rest van de letters van de woord Lowercase worden.
	 * 
	 * @param String[] waardes: De String array met de waardes van de geselecteerde cellen, hierin is alleen de eerste waarde relevant, omdat PROPER op 1 String werkt.
	 * @return String: De nieuwe string met de juiste vorm.
	 * 
	 * Bijv:  "gOoD MOrNING wOrLd" -->  "Good Morning World"
	 */

	public String executable(String[] a) {
		// De eerste String van a wordt toegewezen aan sentence
		String sentence = a[0];

		// Boolean WhiteSp is om te bepalen of de vorige character een
		// whitespace was.
		boolean WhiteSp = true;

		// Van de string sentence maken we een array van characters.
		char[] chars = sentence.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			// Er wordt eerst gekeken of de character een letter is
			if (Character.isLetter(chars[i])) {
			// Dan wordt er gekeken of Boolean WhiteSp true is.
				if (WhiteSp) {
			// Als het true is betekent het dat voor deze character een whitespace was 
			// en dus is dit character de eerste letter van de woord en mag als uppercase veranderd worden
					chars[i] = Character.toUpperCase(chars[i]);
				}else{
			// Als het vorige character geen whitespace is moet deze character veranderd worden in lowercase
					chars[i] = Character.toLowerCase(chars[i]); 
					}
				WhiteSp = false;
			} else {
			// De boolean WhiteSp wordt veranderd naar het feit of de character nu een whitespace is of niet.
			// Dit wordt gedaan zodat de volgende rond van de loop ook juist kan lopen met WhiteSp
				WhiteSp = Character.isWhitespace(chars[i]);
			}
		}
		// Alle letters zijn nu in de goede Uppercase of Lowercase vorm en wij kunnen hun in een nieuwe String zetten en retourneren
		return new String(chars);
	}
}
