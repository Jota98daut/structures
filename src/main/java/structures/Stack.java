package structures;

public interface Stack<T> {

	/**
	 * Add an element to the top of the stack.
	 * @param e the element to push
	 * @throws NullPointerException if e is null
	 */
	public void push(T e);

	/**
	 * Retreive and remove the top element of the stack.
	 * @return the top element
	 * @throws IllegalStateException if the stack is empty
	 */
	public T pop();

	/**
	 * Retreive the top element of the stack.
	 * @return the top element
	 * @throws IllegalStateException if the stack is empty
	 */
	public T peek();

	/**
	 * Return whether the stack is empty.
	 * @return true if the stack is empty, false otherwise
	 */
	public boolean isEmpty();

	/**
	 * Remove all elements of this stack.
	 */
	public void clear();

	/**
	 * Retreive the number of elements in this stack.
	 * @return the number of elements in the stack
	 */
	public int size();

}
