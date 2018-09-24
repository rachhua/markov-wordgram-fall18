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
	 * Create WordGram (add comments)
	 * @param source
	 * @param start
	 * @param size
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
	 * Complete this comment
	 * @return
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
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
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




