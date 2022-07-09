package structures;

public class Sorting {

	public static void selectionSort(Comparable[] a) {
		int n = a.length;
		for(int last = n-1; last >= 1; last--) {
			int largest = indexOfLargest(a, 0, last);
			swap(a, largest, last);
		}
	}

	public static void bubbleSort(Comparable[] a) {
		int n = a.length;
		boolean finished = false;
		for(int last = n-1; last > 0 && !finished; last--) {
			finished = true;
			for(int i = 0; i < last; i++) {
				if(a[i].compareTo(a[i+1]) > 0) { // a[i] > a[i+1]
					swap(a, i, i+1);
					finished = false;
				} 
			}
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
