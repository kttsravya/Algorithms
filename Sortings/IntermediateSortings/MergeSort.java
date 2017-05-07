package Outco_Sorting2_IntermediateSortings;

import java.util.Arrays;
// time comp: O(nlogn)
// Aux space comp: O(n)
// stable sort
// slower than quick sort
// mainly used to sort objects because of stability
public class MergeSort {
	public static void main(String[] args) {
		//
		int[] array = { 2, 4, 5, 7, 1, 2, 3, 6 };
		mergeSort(array);
		System.out.println(Arrays.toString(array));
	}

	private static void mergeSort(int[] array) {
		mergeSortStart(array, 0, array.length - 1);
	}

	private static void mergeSortStart(int[] array, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSortStart(array, start, mid);
			mergeSortStart(array, mid + 1, end);
			merge(array, start, mid, end);
		}

	}

	private static void merge(int[] array, int start, int mid, int end) {
		int[] array1 = new int[mid - start + 1];
		int[] array2 = new int[end - mid];
		int startIncrementor = start;
		int secondStartIncrementor = mid + 1;
		for (int i = 0; i < array1.length; i++) {
			array1[i] = array[startIncrementor];
			startIncrementor++;
		}
		for (int j = 0; j < array2.length; j++) {
			array2[j] = array[secondStartIncrementor];
			secondStartIncrementor++;
		}

		int i = 0;
		int j = 0;
		while (i < array1.length && j < array2.length) {
			if (array1[i] <= array2[j]) {
				array[start] = array1[i];
				start++;
				i++;
			} else if (array1[i] > array2[j]) {
				array[start] = array2[j];
				start++;
				j++;
			}
		}

		if (i < array1.length) {
			while (i < array1.length) {
				array[start] = array1[i];
				i++;
				start++;
			}
		}

		if (j < array2.length) {
			while (j < array2.length) {
				array[start] = array2[j];
				j++;
				start++;
			}
		}
	}
}
