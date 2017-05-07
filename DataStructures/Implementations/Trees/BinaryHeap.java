package Outco_DS2_Trees;

import java.util.Arrays;

//parent = (i - 1)/2, left child = 2*i + 1, right child = 2*i + 2;

public class BinaryHeap {
//	public static void main(String[] args) {
//
//		// int[] array = {100, 30, 80, 40, 60, 60, 70, 35, 10, 50};
//		int[] array = { 50, 10, 35, 70, 60, 60, 40, 80, 30, 100 };
//
//		// construct a max or min heap from given array of values - (may
//		// requrire maxheapify
//		// procedure on array.length/2 to 1)
//		constructMaxHeap(array);
//
//		System.out.println(Arrays.toString(array));
//
//		// maxHeapify(array, 1);
//		// System.out.println(Arrays.toString(array));
//
//		// insert a node - and after insertion maintain the tree as max or min
//		// heap
//		int[] newArray = insert(array, 120);
//		array = newArray;
//
//		System.out.println(Arrays.toString(newArray));
//
//		// extract(delete) - after extract maintain the tree as max or min heap
//		int[] newArray1 = extractMax(array);
//		array = newArray1;
//
//		System.out.println(Arrays.toString(newArray1));
//	}

	public  int[] extractMax(int[] array) {
		int lastNode = array[array.length - 1];
		int max = array[0];
		int[] newArray = new int[array.length - 1];
		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = array[i];
		}
		newArray[0] = lastNode;
		maxHeapify(newArray, 0);

		return newArray;

	}

	public int[] insert(int[] array, int insertValue) {
		int[] newArray = new int[array.length + 1]; // can replace with
													// arraylist
		newArray = Arrays.copyOf(array, newArray.length);
		newArray[newArray.length - 1] = insertValue;
		int i = newArray.length - 1;
		int parent = (i - 1) / 2;
		while (parent >= 0 && newArray[parent] < newArray[i]) {
			maxHeapify(newArray, parent);
			i = parent;
			parent = (i - 1) / 2;
		}
		return newArray;

	}

	public void constructMaxHeap(int[] array) {
		for (int i = array.length / 2; i >= 0; i--) {
			maxHeapify(array, i);
		}
		
	}

	public void maxHeapify(int[] array, int i) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int largest = i;
		if (left < array.length && array[left] > array[i]) {
			largest = left;
		}
		if (right < array.length && array[right] > array[largest]) {
			largest = right;
		}
		if (largest != i) {
			int temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;
			maxHeapify(array, largest);
		}

	}
}
