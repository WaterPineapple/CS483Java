package sorting;

import arrayutils.PrimitiveArrayUtils;

public final class BubbleSort {
	private BubbleSort() {
	}

	public static void main(String[] args) {
		int[] array = PrimitiveArrayUtils.getRandomArray();
		bubbleSort(array);
		PrimitiveArrayUtils.printArray(array);
	}

	private static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++)
			for (int j = 0; j < array.length - 1; j++)
				if (array[j] > array[j + 1])
					PrimitiveArrayUtils.swap(array, j, j + 1);
	}
}