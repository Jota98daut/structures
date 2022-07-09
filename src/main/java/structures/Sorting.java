package structures;

public class Sorting {

	public static void selectionSort(Comparable[] a) {
		int n = a.length;
		for(int last = n-1; last >= 1; last--) {
			int largest = indexOfLargest(a, 0, last);
			swap(a, largest, last);
		}
	}

	private static void swap(Object[] a, int i, int j) {
		if(i < 0 || j >= a.length)
			throw new IndexOutOfBoundsException("" + i + "," + j);

		Object aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}

	private static int indexOfLargest(Comparable[] a, int l, int h) {
		if(l < 0 || h >= a.length)
			throw new IndexOutOfBoundsException("" + l + "," + h);
		int largest = l;
		for(int i = l; i <= h; i++) {
			if(a[i].compareTo(a[largest]) > 0) // a[i] > a[largest]
				largest = i;
		}
		return largest;
	}

}
