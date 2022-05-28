package structures.impl;

/**
 * Iterator over the elements of a list. Implements Java's Iterator interface.
 * @author Joel D'Autilio
 * @params T the type of the elements to iterate over
 */
public class ListIterator<T> implements Iterator<T> {

	public ListIterator(Node<T> node) 
	{ currentNode = node; }

	public boolean hasNext()
	{ return currentNode.next() != null && currentNode.next().data() != null; }

	public T next() {
		if( !hasNext() )
			throw new NoSuchElementException( "no more elements" );

		currentNode = currentNode.next();
		return currentNode.data();
	}

	public boolean hasPrevious()
	{ return currentNode.previous() != null && currentNode.previous().data() != null; }

	public T previous() {
		if( !hasPrevious() )
			throw new NoSuchElementException( "no more elements" );

		currentNode = currentNode.previous();
		return currentNode.data();
	}

	public void remove() 
	{ throw new UnsupportedOperationException( "not supported" ); }

	private Node<T> currentNode;

}
