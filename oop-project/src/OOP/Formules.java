package OOP;

	public class Formules {
	    public double MIN(double a, double b){
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
	    }
	    
	    public int MOD(int number,int divisor){
	        int modulus = 0;
	        //the MOD function only gives you the remainder as an answer MOD(5,2)=1
	        return modulus;
	    }
	    
	    public boolean NOT(boolean x){
	        /**
	         * geeft de inverse waarde terug true wordt false
	         *    true wordt omgezet in false
	         *    false wordt omgezet in true
	         */
	        boolean temp=false;
	        if(x=true){
	            temp=false;
	        }else{
	            temp=true;
	        }
	        
	        return temp;
	    }
	    
	    public boolean OR(){
	        /**
	         * er mogen meerdere parameters worden gegven
	         *    Er wordt een true geretourneerd als er tenminste 1 parametere een 'true oplevert
	         */    
	        boolean waarde=false;
	        
	        
	        return waarde;
	    }
	    
	    
	    
	    public double POWER(double num, double p){
	        // Deze methode geeft berekent de waarde van de 1ste parameter tot de macht van de 2de parameter
	        
	        return Math.pow(num, p);
	    }
	    
	    
	    public double PRODUCT(double a, double b){
	        // Product van de twee parameters
	        double ans=0;
	        
	        ans = a * b;
	        
	        return ans;
	    }
	    
	    public String PROPER(String upper){    
	        /**
	         * als een string uit alleen hoofdletters kan je met deze methode
	         * tot de normale vorm brengen met de eerste letter als hoofdletter en de rest met kleine letters
	         */
	        String result = null;
	        
	        return result;
	    }
	    
	    public double ROUNDDOWN(double num,int aantal){
	        /**
	         * deze methode rondt het getal af naar beneden.
	         * De tweede parameter geeft aan hoeveel cijfers na de komma mogen blijven en de rest van de cijfers worden weg gelaten.
	         * De nieuwe getal wordt geretourneerd
	         */
	        double ans=0;
	        
	        return ans;
	    }
	    
	    public double ROUNDUP(double num,int aantal){
	        /**
	         * Deze methode rondt het getal af naar boven.
	         * De tweede parameter geeft aan hoeveel cijfers na de komma mogen blijven en de rest van de cijfers worden weg gelaten.
	         * Er wordt dan dan 1 opgeteld bij de nieuwe getal en het wordt geretourneerd
	         */
	        double ans=0;
	        
	        return ans;
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
