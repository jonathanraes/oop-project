package OOP;

public class INT extends Formule {

	public String executable(String[] a) {
		/* Stap 1: De double parser (INT kan gewoon geparsed worden als double) in de abstracte klasse Formule wordt aangeroepen. 
		Hoeft maar 1x.
		 De double wordt hier uit de array gehaald + toegewezen aan 'getal'.
		*/
		double getal = Double.parseDouble(a[0]);
		int intgedeelte = 0;
		// Hiervan moeten we de INT-waarde weten.
		
		// Omdat positieve getallen naar beneden worden afgerond en negatieve getallen
		// afgerond worden naar het dichtsbijzijnde gehele getal, maken we een onderscheid,
		// beginnend met positieve getallen.
		if(getal>=0)
			/* De for-loop haalt steeds 1 waarde van het getal af
			 * terwijl het getal groter blijft dan 1.0
			 * Op het moment dat het getal kleiner is dan 1.0 (en dus het int-gedeelte
			 * van de double ervan af is getrokken) stopt de for-loop. Per for-cyclus
			 * wordt aan variabel intgedeelte de waarde i toegekent + 1 (omdat 0 ook meetelt
			 * in de for-loop, maar wij vanaf 1 beginnen te tellen.
			*/
			for(int i = 0; getal > 1.0; i++){
				getal = getal - 1;
				intgedeelte = i + 1;
				
		// Nu gaan we over naar de negatieve getallen
		}else{
			/* Hier gebruik ik dezelfde for-loop als hierboven, alleen veranderd ik het getal in de voorwaarde
			 * naar -1, om de loop hierboven te 'spiegelen' als het ware. Wederom krijg je dus het integer gedeelte
			 * van de double na de loop.
			 */
			for(int i = 0; getal < -1; i++){
				getal = getal + 1;
				intgedeelte = i + 1;
			}
			/* Echter in geval van negatieve getallen moesten we afronden naar het dichtbijzijnde getal, integenstelling
			 * tot de positieve getallen hierboven. Het rest, wat we overhouden in variabel getal, vergelijk ik dus met het getal
			 * -0.5. Als het rest namelijk kleiner of gelijk is dan -0.5 (oftewel -1 < x <=-0.5) dan wordt er bij intgedeelte
			 * 1 waarde opgeteld. Is het rest groter dan -0.5 (oftewel -0.5 < x < 0) dan wordt er niets gedaan.
			 * 
			 */
			if(getal <= -0.5){
				intgedeelte = intgedeelte + 1;
			}
		}
		return "" + intgedeelte + "";
	}	
}
