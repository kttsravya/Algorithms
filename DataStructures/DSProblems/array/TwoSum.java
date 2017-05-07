package WhiteBoard;

import java.util.HashMap;

//DS used: array, HashMap
//TimeComplexity : O(n)
//Auxiliary Space Complexity : O(n)

public class TwoSum {

	public static void main(String[] args) {
		// int[] array = { 1, 6, -5, 7, 3 };
		// int targetElement = -2;
		int[] array = { 1, 9, 10 };
		int targetElement = 8;
		int[] sol = twoSum(array, targetElement);
		System.out.println(sol[0] + " " + sol[1]);
	}

	private static int[] twoSum(int[] array, int targetElement) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(array[0], 0);
		int[] output = new int[2];

		for (int i = 1; i < array.length; i++) {
			int x = array[i];
			if (map.containsKey(targetElement - x)) {
				output[0] = map.get(targetElement - x);
				output[1] = i;
				return output;
			}
			map.put(array[i], i);
		}
		output[0] = -1;
		output[1] = -1;
		return output;

	}
}
