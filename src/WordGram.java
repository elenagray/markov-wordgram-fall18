import java.util.ArrayList;

/**
 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author Elena Gray
 *
 */

public class WordGram {

	private String[] myWords;
	private String myToString; // cached string
	private int myHash; // cached hash value

	/**
	 * Create a WordGram that represents a sequence of strings
	 * 
	 * @param source
	 * @param start
	 * @param size
	 */
	public WordGram(String[] source, int start, int size) {
		myToString = null;
		myHash = 0;
		// TODO: initialize myWords and ...
		ArrayList<String> wordlist = new ArrayList<String>();
		for (int i = start; i < start + size; i++) {
			wordlist.add(source[i]);
		}
		myWords = wordlist.toArray(new String[size]);
	}

	/**
	 * Return string at specific index in this WordGram
	 * 
	 * @param index in range [0..length() ) for string
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt " + index);
		}
		return myWords[index];
	}
	
	/**
	 * Return length of myWords
	 * 
	 * @return myWords.length
	 */
	
	public int length() {
		return myWords.length;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof WordGram) || o == null) {
			return false;
		}
		WordGram wg = (WordGram) o;
		if (wg.length() != this.myWords.length) {
			return false;
		}
		for (int i = 0; i < myWords.length; i++) {
			if (!(wg.myWords[i].equals(myWords[i]))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}

	/**
	 * 
	 * Return shifted WordGram with parameter last
	 * 
	 * @param last is last String of returned WordGram
	 * @return new WordGram object with replaced last element
	 */
	
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords, 0, myWords.length);
		for (int i = 0; i < myWords.length - 1; i++) {
			wg.myWords[i] = wg.myWords[i + 1];
		}
		wg.myWords[wg.myWords.length - 1] = last;
		return wg;
	}

	@Override
	public String toString() {
		myToString = String.join(" ", myWords);
		return myToString;
	}
}
