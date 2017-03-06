package sorting;

import arrayutils.ArrayUtils;

public final class MergeSort {
	private MergeSort() {
	}

	public static void main(String[] args) {
		Integer[] array = ArrayUtils.getIntegerArray();
		mergesort(array);
		ArrayUtils.printArray(array);
	}

	private static void mergesort(Integer[] array) {
		mergesort(new Integer[array.length], array, 0, array.length - 1);
	}

	private static void mergesort(Integer[] auxArray, Integer[] array, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergesort(auxArray, array, low, mid);
			mergesort(auxArray, array, mid + 1, high);
			merge(auxArray, array, low, mid, high);
		}
	}

	private static void merge(Integer[] auxArray, Integer[] array, int low, int mid, int high) {
		int m = mid + 1;
		int l = low;
		int j = 0;
		while (l <= mid && m <= high)
			if (array[l].compareTo(array[m]) > 0)
				auxArray[j++] = array[m++];
			else
				auxArray[j++] = array[l++];
		while (l <= mid)
			auxArray[j++] = array[l++];
		while (m <= high)
			auxArray[j++] = array[m++];
		for (int i = 0; i < j; i++)
			array[i + low] = auxArray[i];
	}
}