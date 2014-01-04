package Formules;

/**
 * LOWER klasse. Hier wordt de binnenkomende String geconvteerd naar alleen maar kleine letters.
 */
public class LOWER extends Formule {
	/**
	 * Hier wordt de eerste String in de StringLijst a genomen en geconverteerd naar alleen maar kleine letters. Hierbij maken we gebruik van toLowerCase()
	 * in de klasse String.
	 * @param String[] waardes: String array met de waardes van de cellen
	 * @return String: Hierin wordt de String teruggegeven, maar dan alleen in kleine letters.
	 */
	public String executable(String[] a) {
		// Voor het converteren naar kleine letters maken we gebruik van de methode toLowerCase() in de klasse String. Deze returnen we ook direct.
		return a[0].toLowerCase();
	}

}
