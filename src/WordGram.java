import java.util.Arrays;


/**
 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author Rachel Hua
 *
 */

public class WordGram {

	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Constructor creates and initializes new WordGram object
	 * @param source is an array of Strings 
	 * @param start is the index that myWords starts copying from source
	 * @param size is the amount of Strings that are copied from source into myWords
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		for (int i = 0; i < size; i++) {
			myWords[i] = source[start + i];
		}	
		// TODO: initialize myWords and ...
		myToString = null;
		myHash = 0;
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Returns the order or size of the WordGram
	 * @return int representing the size of the WordGram
	 */
	public int length(){
		//TODO: change this
		return myWords.length;

	}


	@Override
	//first check if obj is WordGram (cast it or not)
	//then check if they're the same length
	//then make a forloop and check it all inside
	//then return false at the end if it doesn't work

	public boolean equals(Object o) {
		if (!(o instanceof WordGram || o == null)) {
			return false;
		}
		WordGram wg = (WordGram) o;
		if(wg.length() != this.length()) {
			return false;
		}		
		for(int i = 0; i < myWords.length; i++) {
			if (!(myWords[i].equals(wg.wordAt(i)))) {
				return false;
			}
		}
		return true;
	}

	//CORRECT: checked by TA
	@Override
	public int hashCode() {
		// TODO: complete this method
		if (myHash == 0) {
			myHash = toString().hashCode();
		}
		return myHash; 

	}


	/**
	 * Creates and returns a new WordGram object with k entries
	 * (where k is the order of this WordGram) whose first k-1
	 * entries are the same as the last k-1 entries of this WordGram, and whose
	 * last entry is the parameter "last." 
	 * 
	 * @param last is last String of returned WordGram
	 * @return new WordGram with changes as mentioned above
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		// TODO: Complete this method
		for(int i = 0; i< myWords.length-1; i++) {
			wg.myWords[i] = wg.myWords[i+1];
		}
		wg.myWords[myWords.length-1]=last;
		return wg;
	}

	@Override
	//CORRECT: checked by TA
	public String toString(){
		// TODO: Complete this method
		if (myToString == null) {
			myToString = String.join(" ", myWords);
		}
		return myToString;
	}
}




