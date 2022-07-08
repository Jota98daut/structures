package structures.impl;

import structures.Stack;

public class ArrayStack<T> implements Stack<T> {

	private T[] array;
	private int top;
	private static final int DEFAULT_SIZE = 50;

	@SuppressWarnings("unchecked")
	public ArrayStack(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	public ArrayStack() 
	{ this(DEFAULT_SIZE); }

	@Override
	public void push(T e) {
		if(e == null)
			throw new NullPointerException("null element");
		if(top == array.length - 1)
			addCapacity();

		array[++top] = e;
	}

	@SuppressWarnings("unchecked")
	private void addCapacity() {
		T[] newArray = (T[]) new Object[array.length * 2];
		System.arraycopy(array, 0, newArray, 0, top+1); // newArray <- array
		array = newArray;
	}

	@Override
	public T pop() {
		if(top == -1)
			throw new IllegalStateException("empty stack");

		return array[top--];
	}

	@Override
	public T peek() {
		if(top == -1)
			throw new IllegalStateException("empty stack");

		return array[top];
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public void clear() {
		top = -1;
	}

	public int size() {
		return top + 1;
	}

}
