package structures;

public interface Queue<T> {

	/**
	 * Add an element to the tail of the queue.
	 * @param e the element to add
	 * @throws NullPointerException if e is null
	 */
	public void enqueue(T e);

	/**
	 * Retreive and remove the element at the head of the queue.
	 * @return the element at the head of the queue
	 * @throws IllegalStateException if the queue is empty
	 */
	public T dequeue();

	/**
	 * Retreive the element at the head of the queue
	 * @return the element at the head of the queue
	 * @throws IllegalStateException if the queue is empty
	 */
	public T peek();

	/**
	 * Return whether the queue is empty.
	 * @return true if the queue has 0 elements, false otherwise
	 */
	public boolean isEmpty();

	/**
	 * Remove all elements in the queue.
	 */
	public void clear();

	/**
	 * Return the number of elements contained in the queue.
	 * @return the number of elements in the queue
	 */
	public int size();

}
