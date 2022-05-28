package structures.impl;

class Node<T> {

	Node<T>()
	{ this(null); }

	Node<T>(T e)
	{ data = e; }

	T data()
	{ return data; }

	void setData(T e)
	{ data = e; }

	Node<T> next()
	{ return next; }

	void setNext(Node<T> node)
	{ next = node; }

	Node<T> previous()
	{ return prev; }

	void setPrevious(Node<T> node)
	{ prev = node; }

	private T data;
	private Node<T> prev = null;
	private Node<T> next = null;

}
