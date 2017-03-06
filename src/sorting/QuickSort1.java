package sorting;

import arrayutils.ArrayUtils;

public final class QuickSort1 {
	private QuickSort1() {
	}

	public static void main(String[] args) {
		Integer[] array = ArrayUtils.getIntegerArray();
		quickSort(array);
		ArrayUtils.printArray(array);
	}

	public static void quickSort(Integer[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(Integer[] array, int low, int high) {
		if (low < high) {
			int pivot = partition(array, low, high);
			quickSort(array, low, pivot - 1);
			quickSort(array, pivot + 1, high);
		}
	}

	private static int partition(Integer[] array, int low, int high) {
		int i = low - 1;
		int j = low;
		Integer pivot = (Integer) array[high];
		while (j < high) {
			if (array[j].compareTo(pivot) <= 0) {
				i++;
				ArrayUtils.swap(array, i, j);
			}
			j++;
		}
		ArrayUtils.swap(array, i + 1, j);
		return i + 1;
	}
}