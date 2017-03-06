package arrayutils;

import java.util.Random;

public final class ArrayUtils<T extends Comparable<T>> {
	private ArrayUtils() {
	}

	public static <T extends Comparable<T>> boolean isSorted(T[] array) {
		for (int i = 0; i < array.length - 1; i++)
			if (array[i].compareTo(array[i + 1]) > 0)
				return false;
		return true;
	}

	public static <T extends Comparable<T>> boolean isReverseSorted(T[] array) {
		// to be implemented during MinHeap implementation if I choose to do so .-.
		return false;
	}

	public static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
		T tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public static Integer[] getIntegerArray() {
		Random random = new Random();
		Integer[] array = new Integer[random.nextInt(35) + 10];
		for (int i = 0; i < array.length; i++)
			array[i] = random.nextInt(300);
		return array;
	}

	public static <T extends Comparable<T>> void printArray(T[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length - 1; i++)
			System.out.print(array[i] + ", ");
		if (array.length > 0)
			System.out.print(array[array.length - 1]);
		System.out.println("]");
	}

	public static <T extends Comparable<T>> boolean isHeap(T[] array) {
		for (int i = array.length / 2 - 1; i >= 0; i--) {
			if (i * 2 + 1 <= array.length - 1 && array[i * 2 + 1].compareTo(array[i]) > 0)
				return false;
			if (i * 2 + 2 <= array.length - 1 && array[i * 2 + 2].compareTo(array[i]) > 0)
				return false;
		}
		return true;
	}
}
