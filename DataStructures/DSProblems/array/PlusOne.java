package WhiteBoard;

import java.util.Arrays;

// DS used: array
// TimeComplexity : O(n)
// Auxiliary Space Complexity : O(n)

// if DoublyLinkedList is used instead of arrays, Auxiliary Space Complexity is O(1)
// if ArrayList is Used instead of arrays, Auxiliary Space Complexity is O(1) because get and set
//operations in arrayList is O(1)

public class PlusOne {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3 };
		// int[] array1 = { 1, 9 };
		// int[] array2 = { 9, 9 };

		int[] retArray = plusOne(array);

		System.out.println(Arrays.toString(retArray));

	}

	private static int[] plusOne(int[] array) {

		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] >= 0 && array[i] <= 8) {
				array[i] = array[i] + 1;
				return array;
			} else {
				array[i] = 0;
			}
		}

		int[] newArray = new int[array.length + 1];
		newArray[0] = 1;

		for (int i = 1; i < newArray.length; i++) {
			newArray[i] = 0;
		}
		return newArray;

	}
}
