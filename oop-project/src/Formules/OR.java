package Formules;

/**
 
**/
public class OR extends Formule {
	/**
	 * OR(logical_test1,logical_test2,logical_test3) zoveel mogelijk logical
	 * tests..
	 */

	public String executable(String[] a) {
		int rest = a.length % 3;
		int max = (a.length - rest)/3;
		for (int i = 0; i < max; i++) {
			String expressie = a[(3*i)];
			String waarde1 = a[1+(3*i)];
			String waarde2 = a[2+(3*i)];
			String uitkomst = check(expressie, waarde1, waarde2);
			if(uitkomst.equalsIgnoreCase("true")){
				return "TRUE";
			}
		}
		return "FALSE";
	}

	public String check(String a, String b, String c) {
		String logicalexpression = a;
		String operator;
		String deel1;
		String deel2;
		boolean uitkomst;

		if (logicalexpression.contains("<>")) {
			operator = "<>";
			int plvindex1 = logicalexpression.indexOf(operator.substring(0, 1));
			deel1 = logicalexpression.substring(0, plvindex1);
			deel2 = logicalexpression.substring(plvindex1 + 2,
					logicalexpression.length());
			uitkomst = expression(logicalexpression, deel1, deel2, operator, b, c);
		} else if (logicalexpression.contains("<=")) {
			operator = "<=";
			int plvindex1 = logicalexpression.indexOf(operator.substring(0, 1));
			deel1 = logicalexpression.substring(0, plvindex1);
			deel2 = logicalexpression.substring(plvindex1 + 2,
					logicalexpression.length());
			uitkomst = expression(logicalexpression, deel1, deel2, operator, b ,c);
		} else if (logicalexpression.contains(">=")) {
			operator = ">=";
			int plvindex1 = logicalexpression.indexOf(operator.substring(0, 1));
			deel1 = logicalexpression.substring(0, plvindex1);
			deel2 = logicalexpression.substring(plvindex1 + 2,
					logicalexpression.length());
			uitkomst = expression(logicalexpression, deel1, deel2, operator,b,c);
		} else if (logicalexpression.contains("<")) {
			operator = "<";
			int plvindex = logicalexpression.indexOf(operator);
			deel1 = logicalexpression.substring(0, plvindex);
			deel2 = logicalexpression.substring(plvindex + 1,
					logicalexpression.length());
			uitkomst = expression(logicalexpression, deel1, deel2, operator,b,c);
		} else if (logicalexpression.contains(">")) {
			operator = ">";
			int plvindex = logicalexpression.indexOf(operator);
			deel1 = logicalexpression.substring(0, plvindex);
			deel2 = logicalexpression.substring(plvindex + 1,
					logicalexpression.length());
			uitkomst = expression(logicalexpression, deel1, deel2, operator,b,c);
		} else if (logicalexpression.contains("=")) {
			operator = "=";
			int plvindex = logicalexpression.indexOf(operator);
			deel1 = logicalexpression.substring(0, plvindex);
			deel2 = logicalexpression.substring(plvindex + 1,
					logicalexpression.length());
			uitkomst = expression(logicalexpression, deel1, deel2, operator,b,c);
		} else {
			return "NO LOGICAL EXPRESSION FOUND";
		}

		if (uitkomst) {
			return "true";
		} else
			return "false";

	}

	public boolean expression(String a, String deel1, String deel2, String operator, String b, String c) {
		try {
			// Eerst wordt gekeken naar of deel1 een getal is, zo ja dan wordt
			// het try-block vervolgd, zo niet dan wordt er een exception
			// opgegooid die opgevangen wordt in het catch-blok.
			double deel1getal = Double.parseDouble(deel1);
			/*
			 * Als dit bereikt wordt betekent het dat deel1 geldige informatie
			 * is, namelijk een getal of een cel. Hier wordt dan geconctroleerd
			 * of deel2 een cel is, indien waar dan zijn zowel deel1 als deel2
			 * geldige informatie voor een logische expressie, dus returnt de
			 * formule TRUE.
			 */
			if (celcontrole(deel2)) {
				String deel2cel = c; // Ophalen van de waarde uit de cel.
				try {
					double deel2getal = Double.parseDouble(deel2cel);
					return compare(deel1getal, deel2getal, operator);
				} catch (NumberFormatException NFE2) {
					return false;
				}
			}

			/*
			 * Indien deel2 geen cel is, wordt er gekeken of deel2 een getal is
			 * mbv parseDouble(). Indien de parse lukt en deel2 dus een getal
			 * is, gaat het try-blok verder en wordt er TRUE gereturnt door de
			 * formule, want deel1 en deel2 zijn beide geldige informatie.
			 * Indien 2 geen getal is, wordt er een exception opgegooid en
			 * opgevangen verderop.
			 */
			double deel2getal = Double.parseDouble(deel2);
			return compare(deel1getal, deel2getal, operator);

			// Het catch blok dat de excepties opvangt indien deel1 geen getal
			// is of indien deel1 een getal is maar deel2 niet.
		} catch (NumberFormatException NFE) {
			try {
				// Eerst wordt gekeken naar of deel1 een cel is.
				if (celcontrole(deel1)) {

					String deel1cel = b; // Haal String op uit cel
					double deel1getal = Double.parseDouble(deel1cel);
					// Als deel1 een cel is, wordt gekeken naar of deel2 een cel
					// is.
					double deel2getal;
					if (celcontrole(deel2)) {
						deel2getal = Double.parseDouble(c); // Haal String op
																// uit cel
						return compare(deel1getal, deel2getal, operator);
					}

					/*
					 * Indien deel2 geen cel blijkt te zijn, moet er
					 * gecontroleerd worden of deel2 geen getal is. Wederom met
					 * een parse. Indien de parse lukt zal de return statement
					 * bereikt worden en returnt de formule "TRUE".
					 */
					deel2getal = Double.parseDouble(deel2);
					return compare(deel1getal, deel2getal, operator);

				}
				// Indien deel1 geen cel blijkt te zijn, en ook geen getal, want
				// daarom zitten we in dit catch-blok is de String geen logische
				// expressie meer en dus wordt er "FALSE" gereturnt.
				return false;
				// Hier wordt de exception opgevangen die opgegooid wordt indien
				// deel1 een cel is maar deel2 geen getal en geen cel.
			} catch (NumberFormatException NFE2) {
				// Omdat deel2 geen cel en geen getal is, is de String geen
				// logische expressie. De formule returnt dus "FALSE".
				return false;
			}
		}
	}

	public boolean compare(double deel1getal, double deel2getal, String operator) {
		if (operator.equals("<>")) {
			if (deel1getal != deel2getal)
				return true;
		} else if (operator.equals("<=")) {
			if (deel1getal <= deel2getal)
				return true;
		} else if (operator.equals(">=")) {
			if (deel1getal >= deel2getal)
				return true;
		} else if (operator.equals("<")) {
			if (deel1getal < deel2getal)
				return true;
		} else if (operator.equals(">")) {
			if (deel1getal > deel2getal)
				return true;
		} else {
			if (deel1getal == deel2getal)
				return true;
		}
		return false;
	}

	/**
	 * De methode celcontrole() die controleerd of de meegegeven String wel een
	 * cel definieert.
	 * 
	 * @param cel
	 *            String die gecontroleerd moet worden.
	 * @return true of false boolean afhankelijk van of de inhoud van String cel
	 *         een cel definieert.
	 */
	public boolean celcontrole(String cel) {
		/*
		 * Controleert of de eerste character van de String een letter is en of
		 * de laatste character een getal is. Indien dit waar is returnt deze
		 * methode de boolean true, indien niet dan returnt de methode de
		 * boolean false.
		 */
		if (cel.matches("[a-zA-Z]+[0-9]+")) {
			return true;
		} else
			return false;
	}
}
