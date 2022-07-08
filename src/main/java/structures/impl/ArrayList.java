package structures.impl;

import java.util.Collection;
import java.util.Iterator;

import structures.List;

public class ArrayList<T> implements List<T> {

	private T[] array;
	private int size;

	@SuppressWarnings("unchecked")
	public ArrayList(int size) {
		array = (T[]) new Object[size];
		this.size = 0;
	}

	public ArrayList()
	{ this(50); }

	@Override
	public boolean add(T elem) {
		if(elem == null)
			return false;

		if(isFull()) 
			addCapacity();
		
		array[size++] = elem;
		return true;
	}

	@SuppressWarnings("unchecked")
	private void addCapacity() {
		T[] newArray = (T[]) new Object[array.length * 2];
		for(int i = 0; i < size; i++) {
			newArray[i] = array[i];
		}
		array = newArray;
	}

	private boolean isFull() {
		return array.length == size;
	}

	@Override
	public boolean addAll(Collection<? extends T> col) {
		if(col == null)
			return false;

		for(T elem : col)
			add(elem);
		return true;
	}

	@Override
	public void clear() {
		size = 0;
	}

	@Override
	public boolean contains(Object elem) {
		for(int i = 0; i < size; i++) {
			if(array[i].equals(elem))
				return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> col) {
		if(col == null)
			throw new NullPointerException("null collection");
			
		for(Object elem : col) {
			if(!contains(elem))
				return false;
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayListIterator<>(array, size);
	}

	@Override
	public boolean remove(Object elem) {
		if(elem == null)
			return false;

		for(int i = 0; i < size; i++) {
			if(array[i].equals(elem))
				return remove(i) != null;
		}

		return false;
	}

	@Override
	public boolean removeAll(Collection<?> col) {
		if(col == null)
			return false;

		boolean changed = false;
		for(Object o : col)
			changed = changed || remove(o);

		return changed;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("operation not implemented");
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		Object[] newArray = new Object[size];
		for(int i = 0; i < size; i++) {
			newArray[i] = array[i];
		}
		return newArray;
	}

	@Override
	public <E> E[] toArray(E[] arg0) {
		throw new UnsupportedOperationException("operation not implemented");
	}

	@Override
	public boolean add(int idx, T e) {
		if(e == null) return false;
		if(idx < 0 || idx > size)
			throw new IndexOutOfBoundsException(idx);
		if(isFull())
			addCapacity();

		for(int i = size; i > idx; i--) 
			array[i] = array[i-1];

		array[idx] = e;
		size++;
		return true;
	}

	@Override
	public T remove(int idx) {
		if(idx < 0 || idx >= size)
			throw new IndexOutOfBoundsException(idx);

		T removed = array[idx];
		for(int i = idx; i < size-1; i++)
			array[i] = array[i+1];
		size--;
		return removed;
	}

	@Override
	public T get(int idx) {
		if(idx < 0 || idx >= size)
			throw new IndexOutOfBoundsException(idx);

		return array[idx];
	}

}
