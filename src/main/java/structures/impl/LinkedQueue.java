package structures.impl;

import structures.Queue;

public class LinkedQueue<T> implements Queue<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size;

	public LinkedQueue() {
		head = new Node<T>();
		tail = new Node<T>();
		size = 0;
	}

	@Override
	public void enqueue(T e) {
		if(e == null)
			throw new NullPointerException("null element");

		Node<T> previousNode = tail.previous();
		Node<T> newNode = new Node<>(e);
		newNode.setPrevious(previousNode);
		newNode.setNext(tail);
		previousNode.setNext(newNode);
		tail.setPrevious(newNode);
		size++;
	}

	@Override
	public T dequeue() {
		if(size == 0)
			throw new IllegalStateException("empty queue");

		T retValue = head.next().data();
		Node<T> newHead = head.next().next();
		head.setNext(newHead);
		size--;

		return retValue;
	}

	@Override
	public T peek() {
		if(size == 0)
			throw new IllegalStateException("empty queue");

		return head.next().data();
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		head.setNext(tail);
		tail.setPrevious(head);
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

}
