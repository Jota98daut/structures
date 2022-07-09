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

	public static void insertionSort(Comparable[] a) {
		int n = a.length;
		
		for(int i = 0; i < n; i++) { // A[0..i-1] is sorted 
			Comparable current = a[i];
			int k = i;
			while(k > 0 && a[k-1].compareTo(current) > 0) { // k > 0 AND A[k-1] > current
				a[k] = a[k-1];
				k--;
			}
			a[k] = current;
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
