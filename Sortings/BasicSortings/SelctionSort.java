package Outco_Sorting1;

import java.util.Arrays;

// In every iteration find min element and put it in the sorted portion of the array
// "Selection"Sort : "small" element and "sorted" portion of the array

// average,best,worst time complexity is :O(n^2)
//Auxiliary Space Complexity is: O(1)

public class SelctionSort {

	public static void main(String[] args) {
		int[] array = { 5, 1, 8, 4, 3 };
		selectionSort(array);
		System.out.println(Arrays.toString(array));
	}

	private static void selectionSort(int[] array) {

		int sortedListPointer = -1;
		int whileLoopCounter = array.length;
		// System.out.println("while loop counter value " + whileLoopCounter);

		while (whileLoopCounter != 0) {
			int minIndex = sortedListPointer + 1;
			for (int i = sortedListPointer + 1; i < array.length; i++) {
				if (array[i] < array[minIndex]) {
					minIndex = i;
				}
			}

			int temp = array[sortedListPointer + 1];
			array[sortedListPointer + 1] = array[minIndex];
			array[minIndex] = temp;

			sortedListPointer++;
			whileLoopCounter--;
		}

	}

}
