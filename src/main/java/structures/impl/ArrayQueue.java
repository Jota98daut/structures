package structures.impl;

import structures.Queue;

public class ArrayQueue<T> implements Queue<T> {

	private T[] array;
	private int head;
	private int tail;

	@SuppressWarnings("unchecked")
	public ArrayQueue(int size) {
		array = (T[]) new Object[size];
		head = 0;
		tail = 0;
	}

	@Override
	public void enqueue(T e) {
		if(e == null)
			throw new NullPointerException("null element");
		if(size() == array.length)
			addCapacity();

		array[tail++] = e;
	}

	@SuppressWarnings("unchecked")
	private void addCapacity() {
		T[] newArray = (T[]) new Object[array.length * 2];
		int size = size();
		for(int i = 0; i < size; i++)
			newArray[i] = array[(i + head) % array.length];
		array = newArray;
		head = 0;
		tail = size;
	}

	@Override
	public T dequeue() {
		if(isEmpty())
			throw new IllegalStateException("empty queue");

		T retValue = array[head];
		head = (head + 1) % array.length;
		return retValue;
	}

	@Override
	public T peek() {
		if(isEmpty())
			throw new IllegalStateException("empty queue");

		return array[head];
	}

	@Override
	public boolean isEmpty() {
		return head == tail;
	}

	@Override
	public void clear() {
		head = 0;
		tail = 0;
	}

	@Override
	public int size() {
		return (tail - head + array.length) % array.length;
	}

}
