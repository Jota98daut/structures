package structures;

import java.util.Iterator;

public interface ListIterator<T> extends Iterator<T> {

	/**
	 * Check whether there is a previous element.
	 * @return true iff there is a previous element
	 */
	public boolean hasPrevious();

	/**
	 * Advance the iterator to the previous element and return its element.
	 * @return the previous element
	 * @throw NoSuchElementException if the iterator has no more elements to the left
	 */
	public T previous();

}
