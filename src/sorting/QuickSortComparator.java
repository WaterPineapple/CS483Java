package sorting;

import java.util.Random;

public final class QuickSortComparator {
	private QuickSortComparator() {
	}

	public static void main(String[] args) {
		int quickSort1Wins = 0;
		int quickSort2Wins = 0;
		for (int i = 0; i < 100; i++) {
			long sort1StartTime, sort1EndTime, sort2StartTime, sort2EndTime;
			sort1StartTime = System.nanoTime();
			for (int j = 0; j < 10; j++)
				QuickSort1.quickSort(getIntegerArray());
			sort1EndTime = System.nanoTime();
			sort2StartTime = System.nanoTime();
			for (int j = 0; j < 10; j++)
				QuickSort2.quickSort(getIntegerArray());
			sort2EndTime = System.nanoTime();
			if (sort2EndTime - sort2StartTime < sort1EndTime - sort1StartTime)
				quickSort2Wins++;
			else if (sort2EndTime - sort2StartTime == sort1EndTime - sort1StartTime)
				;
			else
				quickSort1Wins++;
		}
		if (quickSort2Wins > quickSort1Wins)
			System.out.println("QuickSort2 won " + (quickSort2Wins - quickSort1Wins) + " more times");
		else
			System.out.println("QuickSort1 won " + (quickSort1Wins - quickSort2Wins) + " more times");
	}

	public static Integer[] getIntegerArray() {
		Random random = new Random();
		Integer[] array = new Integer[10000];
		for (int i = 0; i < array.length; i++)
			array[i] = random.nextInt(300);
		return array;
	}
}
