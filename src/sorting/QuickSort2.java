package sorting;

import arrayutils.ArrayUtils;
// heavily inspired from Wayne and Sedgewick
// a "better" quicksort vs the CRLS version
public final class QuickSort2 {
	private QuickSort2() {
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
		int i = low;
		int j = high + 1;
		Integer pivot = array[low];
		while (true) {
			while (array[++i].compareTo(pivot) <= 0)
				if (i >= high)
					break;
			while (array[--j].compareTo(pivot) >= 0)
				if (j <= low)
					break;
			if (i >= j)
				break;
			ArrayUtils.swap(array, i, j);
		}
		ArrayUtils.swap(array, low, j);
		return j;
	}
}
