package structures.impl;

import structures.ListIterator;

public class ArrayListIterator<T> implements ListIterator<T> {

    private T[] array;
    private int position;
    private int size;

    public ArrayListIterator(T[] array, int size) {
        if(array == null)
            throw new NullPointerException("null array");

        this.array = array;
        this.size = size;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < size;
    }

    @Override
    public T next() {
        if(position == size - 1)
            throw new IndexOutOfBoundsException(position + 1);

        return array[++position];
    }

    @Override
    public boolean hasPrevious() {
        return position > 0;
    }

    @Override
    public T previous() {
        if(position == 0)
            throw new IndexOutOfBoundsException(position - 1);

        return array[--position];
    }
    
}
