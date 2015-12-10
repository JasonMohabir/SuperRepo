
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
    public int linSearch(Comparable c){
	for (int i = index; i < _lastPos; i++)
	    if (_date[i]).equals(c) {return i;}
    }

    public boolean isSorted(){
	boolean retBool = true; 
	for (int i = index; i < _lastPos; i++)
    }


    //main method for testing
    public static void main( String[] args ) 
    {
	//testing for interface over implementation
	SuperArray daemon = new SuperArray();

	System.out.println("Printing empty daemon");
	System.out.println(daemon);
	for (int i = 0; i < 10; i++){ //error with daemon._data.length
	    daemon.add(i);
	}
	System.out.println("Printing numberified daemon...");
	System.out.println(daemon);
	System.out.println("Removing 9th element");
	daemon.remove(8);
	System.out.println(daemon);
	System.out.println(daemon.size());
    }
}
