package structures;

import java.util.Random;

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

	public static void mergeSort(Comparable[] a) {
		int n = a.length;
		auxMergeSort(a, 0, n);
	}

	private static void auxMergeSort(Comparable[] a, int l, int h) {
		if(l < 0 || h > a.length)
			throw new IndexOutOfBoundsException("" + l + "," + h);

		if(h - l < 2) // Base cases: 0 or 1 elements
			return;

		int m = (h + l) / 2;
		auxMergeSort(a, l, m);
		auxMergeSort(a, m, h);
		merge(a, l, m, h);
	}

	public static void quickSort(Comparable[] a) {
		auxQuickSort(a, 0, a.length-1);
	}

	private static void auxQuickSort(Comparable[] a, int lo, int hi) {
		if(lo < hi) {
			// int p = partition(a, lo, hi);
			// auxQuickSort(a, lo, p);
			int p = dutchflag(a, lo, hi);
			auxQuickSort(a, lo, p-1);
			auxQuickSort(a, p+1, hi);
		}
	}

	public static void countingSort(int[] a) {
		// Target array B
		int[] b = new int[a.length];

		// Find max integer k
		int k = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[i] < 0) throw new IllegalArgumentException("array values must be non negative");
			k = Math.max(k, a[i]);
		}

		// Auxiliary array C initialized with 0's
		int[] c = new int[k+1];
		
		// Populate C: c[i] represents the number of values less or equal to i
		for(int i = 0; i < a.length; i++)
			c[a[i]]++;
		for(int i = 1; i <= k; i++)
			c[i] += c[i-1];

		// Populate B
		for(int i = a.length-1; i >= 0; i--) {
			b[c[a[i]] - 1] = a[i];
			c[a[i]]--;
		}

		System.arraycopy(b,0,a,0,a.length);
	}

	private static int dutchflag(Comparable[] a, int lo, int hi) {
		Random rand = new Random();
		int pIndex = rand.nextInt(hi - lo + 1) + lo;
		Comparable pivot = a[pIndex];

		int firstEqual = lo;
		int firstUnsorted = lo;
		int lastUnsorted = hi;

		while(firstUnsorted <= lastUnsorted) { // There are unsorted values left
			if(a[firstUnsorted].compareTo(pivot) < 0)
				swap(a, firstUnsorted++, firstEqual++);
			else if(a[firstUnsorted].compareTo(pivot) > 0)
				swap(a, firstUnsorted, lastUnsorted--);
			else
				firstUnsorted++;
		}
		return lastUnsorted; // At this point lastUnsorted <= pivot, and everything to its right is > pivot
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		Random rand = new Random();
		int pIndex = rand.nextInt(hi - lo + 1) + lo;
		Comparable pivot = a[pIndex];

		int i = lo - 1;
		int j = hi + 1;
		while(i < j) {
			do i++; while(a[i].compareTo(pivot) < 0);
			do j--; while(a[j].compareTo(pivot) > 0);
			if(i < j)
				swap(a, i, j);
		}
		return j;
	}

	private static void merge(Comparable[] a, int low, int mid, int high) {
		int size = high - low;
		Comparable[] auxArray = new Comparable[size];
		int l = low;
		int r = mid;
		int k = 0;

		while(l < mid && r < high)
			auxArray[k++] = (a[l].compareTo(a[r]) <= 0) ? a[l++] : a[r++]; // a[l] > a[r] ?

		while(l < mid)
			auxArray[k++] = a[l++];
		while(r < high)
			auxArray[k++] = a[r++];

		System.arraycopy(auxArray, 0, a, low, size);

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
