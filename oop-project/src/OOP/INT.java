package OOP;

public class INT extends Formule {

	@Override
	public String executable(String[] a) {
		/* Stap 1: De double parser (INT kan gewoon geparsed worden als double) in de abstracte klasse Formule wordt aangeroepen. 
		Hoeft maar 1x. 
		*/
		// De double wordt hier uit de array gehaald en toegewezen aan getal.
		double getal;
		int intgedeelte = 0;
		// Hiervan moeten we de INT-waarde weten.
		for(int i = 0; getal > 1.0; i++){
				getal = getal - 1;
				intgedeelte = i;
		}
		return "" + intgedeelte + "";
	}	
}
