package Outco_Sorting2_IntermediateSortings;

import java.util.Arrays;
// timce comp: O(nlogn), worst case: O(n^2) but occurs rarely, unstable
// so mostly used with primitive values
// Spce comp: constant

// 2 to 3 times faster than merge and heap sort

public class QuickSort {
	public static void main(String[] args) {
		int[] array = { 2, 4, 5, 7, 1, 2, 3, 6 };
		quickSort(array);
	}

	private static void quickSort(int[] array) {
		int start = 0;
		int end = array.length - 1;
        quickSortStart(array, start, end);
        System.out.println(Arrays.toString(array));
	}

	private static void quickSortStart(int[] array, int start, int end) {
		if(start < end){
			int pivot = partition(array, start, end);
			quickSortStart(array,start, pivot - 1);
			quickSortStart(array, pivot + 1, end);
		}
		
	}

	private static int partition(int[] array, int start, int end) {
		int range = end - start;
		int randomCalculator = (int)( Math.random()*range) + start;
		
		// exchanging last element with random element
		int pivot = array[randomCalculator];
		System.out.println("pivot is " + pivot);
		array[randomCalculator] = array[end];
		array[end] = pivot;
		
		
	
		int smallElementsBorder = start - 1;
		
		for(int i = start; i < end; i ++){
			if(array[i] <= pivot){
				smallElementsBorder ++;
				int temp = array[smallElementsBorder];
				array[smallElementsBorder] = array[i];
				array[i] = temp;
			}
		}
		array[end] = array[smallElementsBorder + 1];
		array[smallElementsBorder + 1] = pivot;
		
		return smallElementsBorder + 1;
	}
}
