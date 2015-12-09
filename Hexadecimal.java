//Team Sweet hexa-teen -- Bayle Smith-Salzberg and Jason Mohabir
//APCS1 pd10
//HW44 -- This or That or Fourteen Other Things
//2015-12-08

public class Hexadecimal {

    public int _decNum;
    public String _hexNum;
    private final static String HEXDIGITS = "0123456789ABCDEF"; 

    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _hexNum to "0"
      =====================================*/
    public Hexadecimal() { 
	_decNum = 0;
	_hexNum = "0";

    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _hexNum to equiv string of bits
      =====================================*/
    public Hexadecimal( int n ) {
	_decNum = n;
	_hexNum = decToHex(n);
    }


    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative hexary number
      post: sets _hexNum to input, _decNum to decimal equiv
      =====================================*/
    public Hexadecimal( String s ) {
	_hexNum = s;
	_decNum = hexToDec(s);
    }


    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	return _hexNum;
    }


    /*=====================================
      String decToHex(int) -- converts base-10 input to hexary
      pre:  n >= 0
      post: returns String of bits
      eg  decToHex(0) -> "0"
      decToHex(1) -> "1"
      decToHex(2) -> "2"
      decToHex(3) -> "3"
      decToHex(14) -> "14"
      =====================================*/
    public static String decToHex( int n ) {
	String retStr = "";
	while (n > 0){
	    if (n < 16){
		return HEXDIGITS.substring(n, n+1) + retStr;
	    }
	    retStr =  HEXDIGITS.substring(n % 16, n % 16 +1) + retStr;
	    n /= 16;
	}
	return retStr;
    }


    /*=====================================
      String decToHexR(int) -- converts base-10 input to hexary, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToHexR(0) -> "0"
      decToHexR(1) -> "1"
      decToHexR(2) -> "2"
      decToHexR(3) -> "3"
      decToHexR(14) -> "E"
      =====================================*/
    public static String decToHexR( int n ) { 
	if (n < 16)
	    {return HEXDIGITS.substring(n,n+1)+"";}

	return decToHexR(n/16)+ HEXDIGITS.substring(n%16, n%16 + 1) + "";
    }

    /*=====================================
      String hexToDec(String) -- converts base-10 input to hexary
      pre:  s represents non-negative hexary number
      post: returns decimal equivalent as int
      eg  
      hexToDec("0") -> 0
      hexToDec("1") -> 1
      hexToDec("2") -> 2
      hexToDec("3") -> 3
      hexToDec("E") -> 14
      =====================================*/
    public static int hexToDec( String s ) {
	int retInt = 0;
	int placeVal=0;
	for( int i=0; i < s.length(); i++ ) {
	    placeVal = s.length() - 1 - i;
	    retInt += HEXDIGITS.indexOf(s.substring(i,i+1))
		* Math.pow(16,placeVal);
	}
	return retInt;
    }

    /*=====================================
      String hexToDecR(String) -- converts base-10 input to hexary, recursively
      pre:  s represents non-negative hexary number
      post: returns decimal equivalent as int
      eg  
      hexToDecR("0") -> 0
      hexToDecR("1") -> 1
      hexToDecR("2") -> 2
      hexToDecR("3") -> 3
      hexToDecR("E") -> 14
      =====================================*/
    public static int hexToDecR( String s ) { 
	if (s.length()==1) return HEXDIGITS.indexOf(s);
	else return hexToDec( s.substring(1) ) 
		 + HEXDIGITS.indexOf(s.substring(0,1)) 
		 * (int)Math.pow(16, s.length() - 1);
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Hexadecimal
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal hexary values
      =============================================*/
    public boolean equals( Object other ) { 
	//Check for alias                                                                                                                          
	boolean retval = this == other;
	if (!retval)
	    //Check for same class and then see if difference is 0                                                                                   
	    retval = other instanceof Hexadecimal && this.compareTo((Hexadecimal)other) == 0;
        return retval;

    }
    

    /*=============================================
      int compareTo(Object) -- tells which of two Hexary objects is greater
      pre:  other is instance of class Hexary
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/

    public int compareTo( Object other ) {

	if (! ( other instanceof Hexadecimal) ) {
	    throw new ClassCastException ( "\ncompareTo() input not a Hexadecimal");
	}

	if (((Hexadecimal)other)._decNum == this._decNum){
	    return 0;
	}
	else if (((Hexadecimal)other)._decNum > this._decNum){
	    return -1;
	}
	return 1;
    }


    //main method for testing
    public static void main( String[] args ) {

	  System.out.println();
	  System.out.println( "Testing ..." );

	  Hexadecimal b1 = new Hexadecimal(5);
	  Hexadecimal b2 = new Hexadecimal(5);
	  Hexadecimal b3 = b1;
	  Hexadecimal b4 = new Hexadecimal(7);

	  System.out.println( b1 );
	  System.out.println( b2 );
	  System.out.println( b3 );       
	  System.out.println( b4 );       

	  System.out.println( "\n==..." );
	  System.out.println( b1 == b2 ); //should be false
	  System.out.println( b1 == b3 ); //should be true

	  System.out.println( "\n.equals()..." );
	  System.out.println( b1.equals(b2) ); //should be true
	  System.out.println( b1.equals(b3) ); //should be true
	  System.out.println( b3.equals(b1) ); //should be true
	  System.out.println( b4.equals(b2) ); //should be false
	  System.out.println( b1.equals(b4) ); //should be false

	  System.out.println( "\n.compareTo..." );
	  System.out.println( b1.compareTo(b2) ); //should be 0
	  System.out.println( b1.compareTo(b3) ); //should be 0
	  System.out.println( b1.compareTo(b4) ); //should be neg
	  System.out.println( b4.compareTo(b1) ); //should be pos

	  System.out.println( "\nvalue tests decToHex..." );
	  System.out.println (decToHex(5) + "\texpecting 5");
	  System.out.println (decToHex(12) + "\texpecting C");
	  System.out.println (decToHex(15) + "\texpecting F");
	  System.out.println (decToHex(20) + "\texpecting 14");
  	  System.out.println (decToHex(43) + "\texpecting 2B");

	  System.out.println( "\nvalue tests decToHexR..." );
	  System.out.println (decToHexR(5) + "\texpecting 5");
	  System.out.println (decToHexR(12) + "\texpecting C");
	  System.out.println (decToHexR(15) + "\texpecting F");
	  System.out.println (decToHexR(20) + "\texpecting 14");
  	  System.out.println (decToHexR(43) + "\texpecting 2B");

	  System.out.println( "\nvalue tests hexToDec..." );
	  System.out.println (hexToDec("5") + "\texpecting 5");
	  System.out.println (hexToDec("C") + "\texpecting 12");
	  System.out.println (hexToDec("F") + "\texpecting 15");
	  System.out.println (hexToDec("14") + "\texpecting 20");
	  System.out.println (hexToDec("2B") + "\texpecting 43");

	  System.out.println( "\nvalue tests hexToDecR..." );
	  System.out.println (hexToDecR("5") + "\texpecting 5");
	  System.out.println (hexToDecR("C") + "\texpecting 12");
	  System.out.println (hexToDecR("F") + "\texpecting 15");
	  System.out.println (hexToDecR("14") + "\texpecting 20");
	  System.out.println (hexToDecR("2B") + "\texpecting 43");

    }//end main()

} //end class
