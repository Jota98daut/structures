package structures.impl;

public class MinHeap<T extends Comparable<? super T>> {

	public T[] array;
	public int size;

	public MinHeap() { 
		array = (T[]) new Comparable[1]; 
		size = 0;
	}

	public void add(T o) {
		if(o == null) throw new NullPointerException();
		if(size == array.length) expandCapacity();

		array[size++] = o;

		int curr = size - 1;
		while(curr > 0 && array[getParent(curr)].compareTo(o) > 0) { // Parent(i) > o
			swap(curr, getParent(curr));
			curr = getParent(curr);
		}
	}

	public T minimum() { 
		if(size == 0) throw new IllegalStateException("empty heap");
		return array[0]; 
	}

	public T removeMinimum() {
		T retValue = array[0];
		array[0] = array[size-1];
		heapify(0);
		size--;
		return retValue;
	}

	public int size()
	{ return size; }

	private void heapify(int i) {
		int l = getLeftChild(i);
		int r = getRightChild(i);

		int smallest;
		if(l < size && array[l].compareTo(array[i]) < 0) // A[l] < A[i]
			smallest = l;
		else 
			smallest = i;

		if(r < size && array[r].compareTo(array[smallest]) < 0) // A[r] < A[smallest]
			smallest = r;

		if(smallest != i) {
			swap(i, smallest);
			heapify(smallest);
		}
	}

	private void decreaseKey(int i, T key) {
		if(key == null) throw new NullPointerException();
		if(key.compareTo(array[i]) > 0) throw new IllegalArgumentException("new key is greater than actual key");

		while(i > 0 && array[getParent(i)].compareTo(array[i]) > 0) { // Parent(i) > A[i]
			swap(i, getParent(i));
			i = getParent(i);
		} 

	}

	private void swap(int i, int j) { 
		if(i < 0 || i >= size) throw new IndexOutOfBoundsException(i);
		if(j < 0 || i >= size) throw new IndexOutOfBoundsException(j);

		T aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

	private void expandCapacity() {
		T[] newArray = (T[]) new Comparable[array.length * 2];
		System.arraycopy(array, 0, newArray, 0, size);
		array = newArray;
	}

	private int getParent(int i)
	{ return (int) (i - 1) / 2; }

	private int getLeftChild(int i)
	{ return 2*i + 1; }

	private int getRightChild(int i)
	{ return 2*i + 2; }

	public static void main(String[] args) {

		MinHeap<Integer> h = new MinHeap<>();
		h.add(7);
		h.add(15);
		h.add(3);
		h.add(23);
		h.add(1);

		int size = h.size();
		for(int i = 0; i < size; i++) {
			System.out.print(h.removeMinimum() + ", ");
		}
		System.out.println();

	}

}
