package structures.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.function.Predicate;
import structures.List;
import structures.ListIterator;

public class LinkedList<T> implements List<T> {

	public LinkedList() {
		head = new Node<>();
		tail = new Node<>();
		size = 0;
		head.setNext( tail );
		tail.setPrevious( head );
	}

	public LinkedList(Collection<? extends T> col) {
		head = new Node<>();
		tail = new Node<>();
		size = 0;

		Node<T> lastNode = head;
		for( T e : col ) {
			Node<T> node = new Node<>(e);
			size++;
			lastNode.setNext( node );
			node.setPrevious( lastNode );
			lastNode = node;
		}
		lastNode.setNext( tail );
		tail.setPrevious( lastNode );
	}

	/**
	 * Add an element to the tail of this list.
	 * @param e not-null element to be added
	 * @return true iff the element was added
	 *
	 */
	public boolean add(T e) {
		if( e == null ) throw new NullPointerException( "null element" );

		Node<T> newNode = new Node<>(e);
		newNode.setPrevious( tail.previous() );
		newNode.setNext( tail );
		tail.previous().setNext( newNode );
		tail.setPrevious( newNode );
		size++;

		return true;
	}

	/**
	 * Add an element to a specified position of this list.
	 * @param idx position of the list to add the element at, of range [0,n)
	 * @param e not-null element to be added
	 */
	public boolean add(int idx, T e) {
		if( idx < 0 || idx > size )
			throw new IllegalArgumentException( "index " + idx + " out of bounds" );
		if( e == null )
			throw new NullPointerException( "null element" );

		// Go to position idx-1
		Node<T> prevNode = head;
		for( int pos = 0; pos < idx; pos++ )
			prevNode = prevNode.next();

		Node<T> nextNode = prevNode.next();

		Node<T> newNode = new Node<>(e);
		newNode.setPrevious( prevNode );
		newNode.setNext( nextNode );
		prevNode.setNext( newNode );
		nextNode.setPrevious( newNode );
		size++;
		return true;
	}

	/**
	 * Add all elements in the specified collection to the tail of this list.
	 * @param col not-null collection of a subtype of T
	 * @return true iff all elements could be added
	 */
	public boolean addAll( Collection<? extends T> col ) {
		Node<T> lastNode = tail.previous();
		for( T e : col ) {
			Node<T> newNode = new Node<>(e);
			size++;
			newNode.setPrevious( lastNode );
			lastNode.setNext( newNode );
			lastNode = newNode;
		}
		lastNode.setNext( tail );
		tail.setPrevious( lastNode );

		return true;
	}

	/**
	 * Empty this list.
	 */
	public void clear() {
		head.setNext( tail );
		tail.setNext( head );
		size = 0;
	}

	/**
	 * Return whether this list contains the specified element.
	 * @param e the element to search for
	 * @return true iff the specified element exists in this list
	 */
	public boolean contains( Object o ) {
		if( o == null ) return false;

		Node<T> currentNode = head.next();
		while( currentNode.data() != null ) {
			if( o.equals( currentNode.data() ) )
				return true;
		}

		return false;
	}

	/**
	 * Returns whether this list contains all the elements of a specified collection.
	 * @param col not-null collection containing the elements to check
	 * @return true iff this list contains all the elements of the specified collection
	 */
	public boolean containsAll( Collection<?> col ) {
		if( col == null ) throw new NullPointerException( "null collection" );

		for( Object o : col ) {
			if( !contains(o) )
				return false;
		}
		
		return true;
	}

	/**
	 * Check whether an object is equal to this list.
	 * @param o object to check equality
	 * @return true iff the specified object is equal to this list
	 */
	public boolean equals( Object o ) {
		if( o == null ) return false;
		if( o == this ) return true;
		if( !(o instanceof List<?>) ) return false;

		List<Object> oAsList = (List<Object>) o;

		if( oAsList.size() != size ) return false;

		Node<T> currNode = head;
		ListIterator<Object> otherItr = (ListIterator<Object>) oAsList.iterator();
		for( int i = 0; i < size; i++ ) {
			currNode = currNode.next();
			if( !currNode.data().equals( otherItr.next() ) )
				return false;
		}
		return true;
	}

	/**
	 * Check whether this list is empty.
	 * @return true iff the list is empty
	 */
	public boolean isEmpty()
	{ return size == 0; }

	public Iterator<T> iterator() 
	{ return new LinkedListIterator<T>(head); }

	public T get( int idx ) {
		if( idx < -size || idx >= size )
			throw new IllegalArgumentException( "index " + idx + " out of bounds" );

		Node<T> node = goTo(idx);
		return node.data();
	}

	public T remove( int idx ) {
		if( idx < -size || idx >= size )
			throw new IllegalArgumentException( "index " + idx + " out of bounds" );

		Node<T> node = goTo(idx);
		Node<T> prevNode = node.previous();
		Node<T> nextNode = node.next();
		prevNode.setNext( nextNode );
		nextNode.setPrevious( prevNode );
		size--;
		return node.data();
	}

	public boolean remove( Object o ) {
		Node<T> currentNode = head;

		while( !o.equals( currentNode.data() ) ) {
			currentNode = currentNode.next();
			if( currentNode.data() == null )
				return false;
		}

		Node<T> prevNode = currentNode.previous();
		Node<T> nextNode = currentNode.next();
		prevNode.setNext( nextNode );
		nextNode.setPrevious( prevNode );

		size--;
		return true;
	}

	public boolean removeAll( Collection<?> col ) {
		boolean changed = false;
		for( Object o : col ) {
			changed = changed || remove(o); // if set true, it will remain true
		}
		return changed;
	}

	public int size()
	{ return size; }

	public Object[] toArray() {
		Object[] array = new Object[size];
		Node<T> currentNode = head.next();
		int i = 0;
		while( currentNode.data() != null )
			array[i++] = currentNode.data();
		return array;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append( "[" );
		Node<T> currentNode = head.next();
		for( int i = 0; i < size-1; i++ ) {
			str.append( currentNode.data().toString() + ", " );
			currentNode = currentNode.next();
		}
		str.append( currentNode.data().toString() + "]" );
		return str.toString();
	}

	private Node<T> goTo( int idx ) {
		Node<T> currNode;

		if( idx >= 0 ) {
			currNode = head; for( int i = 0; i <= idx; i++ ) currNode = currNode.next();
		} else {
			currNode = tail;
			for( int i = 0; i < -idx; i++ )
				currNode = currNode.previous();
		}
		return currNode;
	}

	public boolean retainAll( Collection<?> col )
	{ throw new UnsupportedOperationException( "unsupported operation" ); }

	public Stream<T> parallelStream()
	{ throw new UnsupportedOperationException( "unsupported operation" ); }

	public Stream<T> stream()
	{ throw new UnsupportedOperationException( "unsupported operation" ); }

	public boolean removeIf( Predicate<? super T> filter )
	{ throw new UnsupportedOperationException( "unsupported operation" ); }

	public int hashCode()
	{ throw new UnsupportedOperationException( "unsupported operation" ); }

	public Spliterator<T> spliterator()
	{ throw new UnsupportedOperationException( "unsupported operation" ); }

	public <E> E[] toArray( E[] array )
	{ throw new UnsupportedOperationException( "unsupported operation" ); }

	private Node<T> head;
	private Node<T> tail;
	private int size;

}
