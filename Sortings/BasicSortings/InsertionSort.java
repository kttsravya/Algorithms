package Outco_Sorting1;

import java.util.Arrays;

// insert at the correct place
// important thing about insertion sort is it is streamable..
// average, worst Time : O(n^2) and best is O(n)
// space is O(1)
// stable sort
// use when num of elements to be sorted is < 10
// better than selection and bubble sort

public class InsertionSort {
 public static void main(String[] args){
	 int[] array = {5, 1, 8, 4, 3};
	 insertionSort(array);
	 System.out.println(Arrays.toString(array));
 }

private static void insertionSort(int[] array) {
	for(int i = 1; i < array.length; i ++){
		int element = array[i];
		int j = i - 1;
		while(j >= 0 && element < array[j]){
			array[j + 1] = array[j];
			j --;
		}
		//if(j + 1 == 0){
			//array[j + 1] = element;
		//}else if(element >= array[j]){
			array[j + 1] = element;
		//}
	}
}
}
