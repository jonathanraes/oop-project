package Formules;
import java.util.*;
import java.math.BigDecimal;
/**
 * MEDIAN klasse. Hier wordt gekeken naar een reeks getallen, waarvan het middelste getal genomen en gereturnt wordt.
 * Bij een oneven aantal getallen wordt het midelste getal gereturnt, bij een even aantal getallen wordt het gemiddelde
 * genomen van de middelste twee getallen.
 */
public class MEDIAN extends Formule {
	/**
	 * Hier wordt gekeken naar hoeveel getallen de StringLijst a heeft en op basis daarvan wordt de mediaan bepaald.
	 * @param String[] waardes: String array met de waardes van de cellen
	 * @return String: Hierin wordt de mediaan teruggegeven.
	 */
	public String executable(String[] a) {
		// Eerst wordt uit a alle getallen gehaald en in de ArrayList<Double> waardes gestopt.
		ArrayList<Double> waardes = new ArrayList<Double>();
		for(int i=0; i<a.length; i++){
			try{
				waardes.add(Double.parseDouble(a[i]));
			}catch(NumberFormatException e){
			}
		}
		
		// Wijzigt de volgorde van de getallen in de ArrayList<Double> in ascending volgorde.
		for(int counter=0; counter<waardes.size();counter++){
			for(int i=0; i<waardes.size()-1; i++){
				if(waardes.get(i) > waardes.get(i+1)){
					double temp = waardes.get(i);
					waardes.set(i, waardes.get(i+1));
					waardes.set(i+1, temp);
				}
					
			}
		}
		
		if(waardes.size() > 0){
			// Lengte van de ArrayList modulo 2, als er een restant van 0 overblijft, is het een geheel getal, anders oneven.
			if(waardes.size() % 2 == 0){
				/*
				 * Bij een even aantal moet het de middelste 2 getallen nemen. Ex:8. 0/1/2/3/4/5/6/7. Middelste twee getallen zijn
				 * 3 en 4. 8/2 = 4. 4-1 = 3. Dit wordt hieronder aan de variabelen "een" en "twee" toegewezen. Het gemiddelde van deze waarden
				 * wordt gereturnt in de variabele.
				 */
				int een = waardes.size() / 2;
				int twee = een - 1;
				return "" + ((waardes.get(een) + waardes.get(twee))/2) + "";
			}else{
				// Bij oneven aantal getallen returnt de formule het middelste getal. Ex: 5. (5-1)/2=2. 0/1/2/3/4. 2 is hier het middelste getal.
				return "" + waardes.get((waardes.size() - 1)/2) + "";
			}
		}else
			return "NO NUMBERS FOUND";
	
	}
}
