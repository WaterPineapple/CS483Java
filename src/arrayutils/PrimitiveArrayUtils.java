package arrayutils;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PrimitiveArrayUtils {
	private PrimitiveArrayUtils() {
	}

	public static void printArray(int[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length - 1; i++)
			System.out.print(array[i] + ", ");
		if (array.length > 0)
			System.out.print(array[array.length - 1]);
		System.out.println("]");
	}

	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public static int[] getRandomArray() {
		Random random = new Random();
		int[] array = new int[random.nextInt(35) + 10];
		for (int i = 0; i < array.length; i++)
			array[i] = random.nextInt(300) + 100;
		return array;
	}

	public static int[] getLargeRandomArray() {
		Random random = new Random();
		int[] array = new int[random.nextInt(1000000) + 1000000];
		for (int i = 0; i < array.length; i++)
			array[i] = random.nextInt(300) + 1;
		return array;
	}

	public static int[] generateArray(String s) {
		Pattern pattern = Pattern.compile("\\d{3}");
		Matcher matcher = pattern.matcher(s);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int count = 0;
		while (matcher.find()) {
			count++;
			list.add(Integer.parseInt(matcher.group()));
		}
		int[] result = new int[count];
		for (int i = 0; i < list.size(); i++)
			result[i] = list.get(i);
		return result;
	}

	public static boolean isSorted(int[] array) {
		for (int i = 0; i < array.length - 1; i++)
			if (array[i] > array[i + 1])
				return false;
		return true;
	}
}