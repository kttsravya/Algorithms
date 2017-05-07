package Outco_Sorting1;

import java.util.Arrays;

//DSUsed: array
// Time Complexity : O(n^2)
// Auxiliary Space Complexity: O(1)

//average,worst time complexity is :O(n^2) and best is : O(n)

// In every iteration largest element is bubbled up to the end of the array.

public class BubbleSort {
	public static void main(String[] args) {
		int[] array = { 5, 1, 8, 4, 8 };
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}

	private static void bubbleSort(int[] array) {
		boolean swap = true;
		int j = 0;
		while (swap) {
			swap = false;
			for (int i = 0; i < array.length - 1 - j; i++) {
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					swap = true;
				}
			}
			j++;
		}
	}
}
