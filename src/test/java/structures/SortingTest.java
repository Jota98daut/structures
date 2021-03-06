package structures;

import org.junit.Test;
import static org.junit.Assert.*;

public class SortingTest {

	@Test
	public void selectionEmptyTest() {
		Integer[] actual = new Integer[] {};
		Sorting.selectionSort(actual);
		Integer[] expected = new Integer[] {};
		assertArrayEquals("Empty array", expected, actual);
	}
@Test public void bubbleEmptyTest() {
		Integer[] actual = new Integer[] {};
		Sorting.bubbleSort(actual);
		Integer[] expected = new Integer[] {};
		assertArrayEquals("Empty array", expected, actual);
	}

	@Test
	public void insertionEmptyTest() {
		Integer[] actual = new Integer[] {};
		Sorting.insertionSort(actual);
		Integer[] expected = new Integer[] {};
		assertArrayEquals("Empty array", expected, actual);
	}

	@Test
	public void mergeEmptyTest() {
		Integer[] actual = new Integer[] {};
		Sorting.mergeSort(actual);
		Integer[] expected = new Integer[] {};
		assertArrayEquals("Empty array", expected, actual);
	}

	@Test
	public void quickEmptyTest() {
		Integer[] actual = new Integer[] {};
		Sorting.quickSort(actual);
		Integer[] expected = new Integer[] {};
		assertArrayEquals("Empty array", expected, actual);
	}

	@Test
	public void countingEmptyTest() {
		int[] actual = new int[] {};
		Sorting.countingSort(actual);
		int[] expected = new int[] {};
		assertArrayEquals("Empty array", expected, actual);
	}

	@Test
	public void selectionUnitaryTest() {
		Integer[] actual = new Integer[] {1};
		Sorting.selectionSort(actual);
		Integer[] expected = new Integer[] {1};
		assertArrayEquals("Unitary array", expected, actual);
	}

	@Test
	public void bubbleUnitaryTest() {
		Integer[] actual = new Integer[] {1};
		Sorting.bubbleSort(actual);
		Integer[] expected = new Integer[] {1};
		assertArrayEquals("Unitary array", expected, actual);
	}

	@Test
	public void insertionUnitaryTest() {
		Integer[] actual = new Integer[] {1};
		Sorting.insertionSort(actual);
		Integer[] expected = new Integer[] {1};
		assertArrayEquals("Unitary array", expected, actual);
	}

	@Test
	public void mergeUnitaryTest() {
		Integer[] actual = new Integer[] {1};
		Sorting.mergeSort(actual);
		Integer[] expected = new Integer[] {1};
		assertArrayEquals("Unitary array", expected, actual);
	}

	@Test
	public void quickUnitaryTest() {
		Integer[] actual = new Integer[] {1};
		Sorting.quickSort(actual);
		Integer[] expected = new Integer[] {1};
		assertArrayEquals("Unitary array", expected, actual);
	}

	@Test
	public void countingUnitaryTest() {
		int[] actual = new int[] {1};
		Sorting.countingSort(actual);
		int[] expected = new int[] {1};
		assertArrayEquals("Unitary array", expected, actual);
	}

	@Test
	public void selectionSmallTest() {
		Integer[] actual = new Integer[] {3,1,2};
		Sorting.selectionSort(actual);
		Integer[] expected = new Integer[] {1,2,3};
		assertArrayEquals("Small array", expected, actual);
	}

	@Test
	public void bubbleSmallTest() {
		Integer[] actual = new Integer[] {3,1,2};
		Sorting.bubbleSort(actual);
		Integer[] expected = new Integer[] {1,2,3};
		assertArrayEquals("Small array", expected, actual);
	}

	@Test
	public void insertionSmallTest() {
		Integer[] actual = new Integer[] {3,1,2};
		Sorting.insertionSort(actual);
		Integer[] expected = new Integer[] {1,2,3};
		assertArrayEquals("Small array", expected, actual);
	}

	@Test
	public void mergeSmallTest() {
		Integer[] actual = new Integer[] {3,1,2};
		Sorting.mergeSort(actual);
		Integer[] expected = new Integer[] {1,2,3};
		assertArrayEquals("Small array", expected, actual);
	}

	@Test
	public void quickSmallTest() {
		Integer[] actual = new Integer[] {3,1,2};
		Sorting.quickSort(actual);
		Integer[] expected = new Integer[] {1,2,3};
		assertArrayEquals("Small array", expected, actual);
	}

	@Test
	public void countingSmallTest() {
		int[] actual = new int[] {3,1,2};
		Sorting.countingSort(actual);
		int[] expected = new int[] {1,2,3};
		assertArrayEquals("Small array", expected, actual);
	}

	@Test
	public void selectionBigTest() {
		Integer[] actual = new Integer[1000];
		for(int i = 0; i < 1000; i++)
			actual[i] = 999 - i;
		Sorting.selectionSort(actual);
		Integer[] expected = new Integer[1000];
		for(int i = 0; i < 1000; i++)
			expected[i] = i;
		assertArrayEquals("Big array", expected, actual);
	}

	@Test
	public void bubbleBigTest() {
		Integer[] actual = new Integer[1000];
		for(int i = 0; i < 1000; i++)
			actual[i] = 999 - i;
		Sorting.bubbleSort(actual);
		Integer[] expected = new Integer[1000];
		for(int i = 0; i < 1000; i++)
			expected[i] = i;
		assertArrayEquals("Big array", expected, actual);
	}

	@Test
	public void insertionBigTest() {
		Integer[] actual = new Integer[1000];
		for(int i = 0; i < 1000; i++)
			actual[i] = 999 - i;
		Sorting.insertionSort(actual);
		Integer[] expected = new Integer[1000];
		for(int i = 0; i < 1000; i++)
			expected[i] = i;
		assertArrayEquals("Big array", expected, actual);
	}

	@Test
	public void mergeBigTest() {
		Integer[] actual = new Integer[1000];
		for(int i = 0; i < 1000; i++)
			actual[i] = 999 - i;
		Sorting.mergeSort(actual);
		Integer[] expected = new Integer[1000];
		for(int i = 0; i < 1000; i++)
			expected[i] = i;
		assertArrayEquals("Big array", expected, actual);
	}

	@Test
	public void quickBigTest() {
		Integer[] actual = new Integer[1000];
		for(int i = 0; i < 1000; i++)
			actual[i] = 999 - i;
		Sorting.quickSort(actual);
		Integer[] expected = new Integer[1000];
		for(int i = 0; i < 1000; i++)
			expected[i] = i;
		assertArrayEquals("Big array", expected, actual);
	}

	@Test
	public void countingBigTest() {
		int[] actual = new int[1000];
		for(int i = 0; i < 1000; i++)
			actual[i] = 999 - i;
		Sorting.countingSort(actual);
		int[] expected = new int[1000];
		for(int i = 0; i < 1000; i++)
			expected[i] = i;
		assertArrayEquals("Big array", expected, actual);
	}

}
