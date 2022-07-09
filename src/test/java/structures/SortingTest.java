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

	@Test
	public void bubbleEmptyTest() {
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

}
