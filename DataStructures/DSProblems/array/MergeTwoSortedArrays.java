package WhiteBoard;

// DS Used : array
// TimeComplexity : O(array1.length + array2.length)
// SpaceComplexity: O(array1.length + array2.length)

public class MergeTwoSortedArrays {
	public static void main(String[] args) {
		int[] array1 = { 1, 5, 10 };
		int[] array2 = { 2, 3, 12, 15 };
		int[] finalArray = merge(array1, array2);

		for (int i = 0; i < finalArray.length; i++) {
			System.out.println(finalArray[i]);
		}
	}

	private static int[] merge(int[] array1, int[] array2) {
		int array1Pointer = 0;
		int array2Pointer = 0;
		int finalArrayPointer = 0;
		int[] mergedArray = new int[array1.length + array2.length];

		while (array1Pointer < array1.length && array2Pointer < array2.length) {
			if (array1[array1Pointer] <= array2[array2Pointer]) {
				mergedArray[finalArrayPointer] = array1[array1Pointer];
				array1Pointer++;
			} else {
				mergedArray[finalArrayPointer] = array2[array2Pointer];
				array2Pointer++;
			}
			finalArrayPointer++;
		}

		if (array1Pointer < array1.length) {
			while (array1Pointer < array1.length) {
				mergedArray[finalArrayPointer] = array1[array1Pointer];
				array1Pointer++;
				finalArrayPointer++;
			}
		}

		if (array2Pointer < array2.length) {
			while (array2Pointer < array2.length) {
				mergedArray[finalArrayPointer] = array2[array2Pointer];
				array2Pointer++;
				finalArrayPointer++;
			}
		}

		return mergedArray;
	}
}
