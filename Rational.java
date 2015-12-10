// Team Neighbors - Joel Ye and Jason Mohabir
// APCS1 pd10
// HW41 -- In America, the Driver Sits on the Left
// 2015-12-03


public class Rational implements Comparable {

    private int num, den;


    // CONSTRUCTORS
    // ===========================================
    //default constructor
    public Rational(){
	num = 0;
	den = 1;
    }
	
    //overloaded constructor: checks for division by 0
    public Rational(int n, int d){
	this();
	if (d == 0) {
	    System.out.print ("MathError: Division by 0.");
	}
	else {
	    num = n;
	    den = d;
	}
    }




    // METHODS
    // ===========================================
	
    //prints rational number with newlines
    public String toString(){
	return num +
	    "\n" + "-" +
	    "\n" + den +
	    "\n";
    }

    
    //float approximation of rational number
    public float floatValue(){
	return (float)(num)/(den);
	//Casting has precedence to division.
    }

    
    //multiplication
    public void multiply (Rational n){
        num *= n.num;
	den *= n.den;
	//Needn't worry about division by 0, param is also rational.
    }
    
	
    //division
    public void divide(Rational n){
	if (n.num == 0){
	    System.out.println("MathError: Division by 0");
	    return;
	}
	num *= n.den;
	den *= n.num;
    }


    
    
    // HW33 ADDITIONS
    // ===========================================

    // calc gcd of two ints
    public static int gcd(int a, int b){
	// deal with negatives
		a = Math.abs(a);
		b = Math.abs(b);
		
        while (b != 0) {
            int num = b;
            b = a % b;
            a = num;
        }
        return a;
    }


    // return gcd of numerator and denominator
    public int gcd(){
	return gcd(num,den);
    }


    // simplify the numerator and denominator of a Rational object
    public static void reduce(Rational n){
	int gcd = gcd(n.num, n.den);
	n.num /= gcd;
	n.den /= gcd;
	if(n.den < 0){
		n.num *= -1;
		n.den *= -1;
		//How in the world is it so compact? Well, if den (and num) is (are) < 0
		//This will make n all positive. If only den is less than 0, sign flips to numerator.
		//If both are positive, w/e.
	}
    }


    // add to another Rational object
    public void add(Rational a){
	num = num * a.den + den * a.num;
	den *= a.den;
	reduce(this);
    }


    // subtract another Rational object
    public void subtract(Rational a){
	num = num * a.den - den * a.num;
	den *= a.den;
	reduce(this);
    }


    //  returns diff of two Rational objects
    public int compareTo(Rational a){
		return num * a.den - den * a.num;
    }
	// returns diff of Rational and object?
	//merges equals and compareTo
	public int compareTo(Object o){
		boolean retval = this == o;
		if (! retval){
			retval = o instanceof Rational;
			if (retval)
				return this.compareTo((Rational)o);
			else
				retval = o instanceof Integer || o instanceof Float || o instanceof Double;
			if (retval){
				double a = this.floatValue() - (Double) o;
				if (a < 0)
					return (int)Math.floor(a);
				else
					return (int)Math.floor(a) + 1;
			}
			else
				System.out.println(o + " cannot be compared with " + this);
			return 0;
		}
		return 0;
	}
	
    //Copied Tile's structure
    public boolean equals(Object a){
    	//Check for alias
    	boolean retval = this == a;
    	if (!retval)
    		//Check for same class and then see if difference is 0 -> Equality
    		retval = a instanceof Rational && this.compareTo((Rational)a) == 0;
    	return retval;
    }

    public static void main(String[] args){

	Rational z = new Rational(1,2);
	System.out.println(z.compareTo(.4));
	
    }

}
