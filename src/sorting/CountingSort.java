package sorting;

import arrayutils.PrimitiveArrayUtils;

public final class CountingSort {
	private CountingSort() {
	}

	public static void main(String[] args) {
		int[] array = PrimitiveArrayUtils.getRandomArray();
		int k, s;
		k = s = 0;
		for (int i = 0, l = 0; i < array.length; i++)
			k = (l = Math.max(l, array[i])) - (s = Math.min(s, array[i]));
		if (k != 0)
			PrimitiveArrayUtils.printArray(countingSort(array, new int[array.length], k, s));
	}

	private static int[] countingSort(int[] array, int[] outputArray, int k, int s) {
		int[] auxArray = new int[k + 1];
		for (int i = 0; i < array.length; i++)
			auxArray[array[i] - s] += 1;
		for (int i = 1; i < auxArray.length; i++)
			auxArray[i] += auxArray[i - 1];
		for (int i = 0; i < array.length; i++) {
			outputArray[auxArray[array[i] - s] - 1] = array[i];
			auxArray[array[i] - s] -= 1;
		}
		return outputArray;
	}
}