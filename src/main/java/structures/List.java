package structures;

import java.util.Collection;

/**
 * List ADT representing a sequence of elements of type T.
 * @author Joel D'Autilio
 * @param T the type of objects the list can hold
 */
public interface List<T> extends Collection<T> {

	/**
	 * Add an element to a specified position of this list.
	 * @param idx position where the element is to be added, in the range [0..n)
	 * @param e non-null element to add
	 * @return true iff the element was correctly added
	 */
	public boolean add(int idx, T e);

	/**
	 * Remove the element in a specified position of this list.
	 * @param idx position where the element will be removed, in the range [0..n)
	 * return the removed element
	 */
	public T remove(int idx);

	/**
	 * Return the element at the specified position of this list.
	 * @param idx index of the element to return, of range [0..n)
	 * @return the element at the specified position
	 */
	public T get(int idx);

}
