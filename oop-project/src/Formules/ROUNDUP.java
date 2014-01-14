package Formules;

public class ROUNDUP extends Formule {

	public String executable(String[] a) {
		/**
		 * Deze methode rondt het getal af naar boven. De tweede parameter geeft
		 * aan hoeveel cijfers na de komma mogen blijven en de rest van de
		 * cijfers worden weg gelaten.
		 */

		String waarde = a[0];

		int dec;
		try {
			Double.parseDouble(a[0]);
			dec = Integer.parseInt(a[1]);
		} catch (NumberFormatException NFS) {
			return "Error1: Not a number!";
		}

		
		if (dec >= 0) {
			String[] temp;
			try {
				temp = waarde.split("[.]");
			} catch (NumberFormatException NFS) {
				return "Error2: Not a number!";
			}

	
			if (temp.length == 2) {
				temp[1] = temp[1].substring(0, dec);
				int e;
				try {
					e = Integer.parseInt(temp[1]);
					e++;
					System.out.print(e);
				} catch (NumberFormatException NFE) {
					return "Error3: Not a number!";
				}

				return temp[0] + "." + e;
			}else{
				return temp[0];
			}
		} else {
			return "fix this!";
		}
	}
}