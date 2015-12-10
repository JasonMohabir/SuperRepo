
//Joel Ye and Jason Mohabir
//APCS1 pd10
//HW42 -- Array of Titanium
//2015 - 12 - 06

/*****************************
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *****************************/

public class SuperArray{

    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Comparable[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;
	
    //~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray() {
	_data = new Comparable[10];
	_lastPos = -1;
	_size = 0;
    }
		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() {
	String s = "[";
	for (int i = 0; i < _size; i++){
	    s += _data[i];
	    s += ",";
	}
	if (_size > 0)
	    s = s.substring(0,s.length() - 1);
	s += "]";
	return s;
    }
		
    //double capacity of this SuperArray
    private void expand() { 
	Comparable[] newArr = new Comparable[2 * _data.length];
	for (int i = 0; i < _lastPos; i++)
	    newArr[i] = _data[i];
	_data = newArr;
    }
	
    //accessor -- return value at specified index
    public int get( int index ) { return _data[index];}

    //accessor -- return _data length
    public int get_dataLength() {return _data.length;}
		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public int set( int index, Comparable newVal ) { 
	int temp = _data[index];
	_data[index] = newVal;
	return temp;
    }

  // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( Comparable newVal ) {
	if (_size == _data.length)
		expand();
	_data[_size] = newVal;
	_size +=1;
	_lastPos += 1;
    }

    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Comparable newVal ) {
	if (index >= _size){
		//Let's throw an error
	}
	if (_size == _data.length)
		expand();
	for (int i = _size; i > index + 1; i--){
	    _data[i] = _data[i - 1];
	}
	_data[index] = newVal;
	_lastPos += 1;
	_size +=1;
    }

    //removes the item at index
    //shifts elements left to fill in newly-emptied slot
    public void remove( int index ) {
	for (int i = index; i < _lastPos; i++)
		_data[i] = _data[i + 1];
	_lastPos -= 1;
	_size -= 1;
	}

    //return number of meaningful items in _data
    public int size() {return _size;}



    //~~~~~~~~~~~~HW 45 Methods~~~~~~~~~~~~~~~~~~~~~
    public int linSearch(Comparable c) {
        for(int i = 0; i <= _lastPos; i++) {
            if(c.compareTo(get(i)) == 0) return i;
        }
        return -1;
    }
    public boolean isSorted() {
        for(int i = 1; i <= _lastPos; i++) {
            if(get(i).compareTo(get(i - 1)) < 0) return false;
        }
        return true;
    }

    //main method for testing
    public static void main( String[] args ) 
    {
	SuperArray a = new SuperArray();
        System.out.println(a._size);
        System.out.println(a._lastPos);
        System.out.println(a);
        a.expand();
        System.out.println(a); //same thing                                                                                                                                                      
        System.out.println(a._lastPos);
        a.add(new Binary("10010"));
        System.out.println(a);
        a.add(new Hexadecimal("7F"));
        System.out.println(a);
        a.add(1,new Rational(5,6));
        System.out.println(a);
        System.out.println(a.size());
        System.out.println(a.linSearch(new Rational(36,2))); //0                                                                                                                                 
        System.out.println(a.linSearch(new Binary("1111111"))); //2                                                                                                                              
        System.out.println(a.linSearch(new Binary(1))); //-1                                                                                                                                     
        System.out.println(a.isSorted()); //false                                                                                                                                                
        a.remove(1);
        System.out.println(a.isSorted()); //true                                                                                                                                                 



    }
}
