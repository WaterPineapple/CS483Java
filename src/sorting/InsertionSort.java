package sorting;

import arrayutils.PrimitiveArrayUtils;

public final class InsertionSort {
	private InsertionSort() {
	}

	public static void main(String[] args) {
		int[] array = PrimitiveArrayUtils.getRandomArray();
		insertionSort(array);
		PrimitiveArrayUtils.printArray(array);
	}

	private static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int tmp = array[i];
			int j;
			for (j = i - 1; j >= 0 && array[j] > tmp; j--)
				array[j + 1] = array[j];
			array[j + 1] = tmp;
		}
	}
}