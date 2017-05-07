package Outco_Sorting2_IntermediateSortings;

import java.util.Arrays;

import Outco_DS2_Trees.BinaryHeap;

// TimeComp : O(nlogn)
// Aux Space : O(1)
// slower than quick sort

public class HeapSort {
 public static void main(String[] args){
	 int[] array = { 2, 4, 5, 7, 1, 2, 3, 6 };
	 BinaryHeap heap = new BinaryHeap();
	 heap.constructMaxHeap(array);
	 int heapSize = array.length - 1;
	 for(int i = array.length - 1; i > 0; i --){
		 int temp = array[0];
		 array[0] = array[i];
		 array[i] = temp;
		 heapSize --;
		 maxHeapify(array,0,heapSize);
	 }
	 System.out.println(Arrays.toString(array));
 }

private static void maxHeapify(int[] array, int i, int heapSize) {
	int left = 2 * i + 1;
	int right = 2 * i + 2;
	int largest = i;
	if (left <= heapSize && array[left] > array[i]) {
		largest = left;
	}
	if (right <= heapSize && array[right] > array[largest]) {
		largest = right;
	}
	if (largest != i) {
		int temp = array[i];
		array[i] = array[largest];
		array[largest] = temp;
		maxHeapify(array, largest, heapSize);
	}
}
}
