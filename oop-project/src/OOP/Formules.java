package OOP;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Formules {

	public static double AVERAGE(double[] array){
		double res = 0;
		for(double value: array){
			res =+ value;
		}
		res = res / array.length;
		return res;
	}

	public static int COUNT(){
		int aantal = 0;
		return aantal;
	}

	public static int COUNTA(){
		int aantal = 0;
		return aantal;
	}

	public static int COUNTIF(String criteria){
		int aantal = 0;
		//Evalueer en werk de criteria uit
		return aantal;
	}

	public static double INT(double d){

		return Math.round(d);
	}

	/*public double MIN(double a, double b){
	         // minimale waarde uitzoeken
	         double minimum = 0;
	         if (a>b){
	         minimum = b;
	         }
	         if (a<b){
	         minimum = a;
	         }
	         return minimum;
	         }

		public double MIN(double a,double b,double c){
	         // minimale waarde uitzoeken
	         double minimum = 0;
	         if (a>b && c>b){
	         minimum = b;
	         }
	         if (a>c && b>c){
	         minimum = c;
	         }
	         if(c>a && b>a){
	         minimum = a;
	         }
	         return minimum;
	         }*/

	public static double MIN(double[] array){
		// minimale waarde uitzoeken
		double minimum = Double.MAX_VALUE;
		for(double value: array){
			if(value < minimum){
				minimum = value;
			}
		}
		return minimum;
	}

	public static int MOD(int number,int divisor){
		//the MOD function only gives you the remainder as an answer MOD(5,2)=1
		return number % divisor;
	}

	public static boolean NOT(boolean x){
		/**
		 * geeft de inverse waarde terug true wordt false
		 *    true wordt omgezet in false
		 *    false wordt omgezet in true
		 */
		if(x == true){
			return false;
		}
		else{
			return true;
		}
	}

	public static boolean OR(boolean[] array){
		/**
		 * er mogen meerdere parameters worden gegven
		 *    Er wordt een true geretourneerd als er tenminste 1 parametere een 'true oplevert
		 */    
		for(boolean b: array){
			if(b == true){
				return true;
			}
		}
		return false;
	}

	public static double POWER(double num, double p){
		// Deze methode geeft berekent de waarde van de 1ste parameter tot de macht van de 2de parameter

		return Math.pow(num, p);
	}

	public static double PRODUCT(double a, double b){
		// Product van de twee parameters
		return a * b;
	}

	public static String PROPER(String upper){    
		/**
		 * als een string uit alleen hoofdletters kan je met deze methode
		 * tot de normale vorm brengen met de eerste letter als hoofdletter en de rest met kleine letters
		 */
		//Deze implementatie werkt alleen voor een enkele zin waarvan de eerste char de eerste letter van de zin is.
		String result = upper.toLowerCase();
		String eersteletter = "" + result.charAt(0);
		result = result.substring(1);
		eersteletter = eersteletter.toUpperCase();
		result = eersteletter + result;
		return result;
	}

	public static double ROUNDDOWN(double num,int aantal){
		/**
		 * deze methode rondt het getal af naar beneden.
		 * De tweede parameter geeft aan hoeveel cijfers na de komma mogen blijven en de rest van de cijfers worden weg gelaten.
		 * De nieuwe getal wordt geretourneerd
		 */
		BigDecimal b = new BigDecimal(num).setScale(aantal, RoundingMode.DOWN);
		double res = b.doubleValue();		
		return res;
	}

	public static double ROUNDUP(double num,int aantal){
		/**
		 * Deze methode rondt het getal af naar boven.
		 * De tweede parameter geeft aan hoeveel cijfers na de komma mogen blijven en de rest van de cijfers worden weg gelaten.
		 */
		BigDecimal b = new BigDecimal(num).setScale(aantal, RoundingMode.UP);
		double res = b.doubleValue();
		return res;
	}

	public int SIGN(double number){
		/**
		 * Het doel van deze methode is om te kijken of de parameter negatief of positief is.
		 *    Als het getal een positief is, wordt er een 1 geretourneerd
		 *    Als het getal een negatief is, wordt er een -1 geretourneerd
		 *    Als het getal een 0 is, wordt er een 0 geretourneerd
		 */
		int result=0;

		if(number>0){
			result=1;
		}
		if(number<0){
			result=-1;
		}

		return result;
	}

	public double SQRT(double number){
		/**
		 * Deze methode geeft de wortel terug van de parameter
		 *
		 */
		return Math.sqrt(number);
	}

	public double SUM(double a,double b){
		//met array?
		/**
		 * retourneert som van parameters
		 */
		double ans=0;

		ans = a+b;

		return ans;        
	}

	public double SUM(double a,double b,double c){
		/**
		 * retourneert som van parameters
		 */
		double ans=0;

		ans = a+b+c;

		return ans;
	}


	public double SUMIF(){
		/**
		 *
		 */
		double ans=0;
		return ans;
	}

}