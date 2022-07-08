package structures.impl;

import structures.Stack;

public class LinkedStack<T> implements Stack<T> {

	private Node<T> head = null;
	private int size = 0;

	@Override
	public void push(T e) {
		if(e == null)
			throw new NullPointerException("null element");

		Node<T> newNode = new Node<>(e);
		newNode.setNext(head);
		head = newNode;
		size++;
	}

	@Override
	public T pop() {
		if(head == null)
			throw new IllegalStateException("empty stack");

		T retValue = head.data();
		head = head.next();
		size--;
		return retValue;
	}

	public T peek() {
		if(head == null)
			throw new IllegalStateException("empty stack");

		return head.data();
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void clear() {
		head = null;
		size = 0;
	}

	public int size() {
		return size;
	}

}
