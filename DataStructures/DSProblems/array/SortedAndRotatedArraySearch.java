package WhiteBoard;

//Given a rotated, sorted array and a target value, return the index of the target value. If the target value does not exist inside of the collection, return -1. 
//A rotated, sorted array means that some number of elements have been taken from one end of the array and moved to the other end while maintaining the sorted status of the moved elements. 
//[1,2,3,4,5,6,7] → [3,4,5,6,7,1,2]
//
//Input: Array of integers, target value
//Output: Integer index of target value (-1 if not found)
//Example
//Input: [6,8,11,15,17,3,5], 3      	=>	Output: 5
//Input: [6,8,11,15,17,3,5], 10		=>	Output: -1
//Constraints
//Time Complexity: O(log(N))
//Auxiliary Space Complexity: O(log(N))
//
//All elements of the array are unique


public class SortedAndRotatedArraySearch {
	public static void main(String[] args) {
		int[] array = { 6, 8, 11, 15, 17, 3, 5 };
		int low = 0;
		int high = array.length - 1;
		int targetValue = 5;
		int index = ModifiedBinarySearch(array, low, high, targetValue);
		System.out.println(index);
	}

	private static int ModifiedBinarySearch(int[] array, int low, int high, int targetValue) {
		while (low <= high) {
			int mid = (low + high) / 2;
			int startValue = array[low];
			int endValue = array[high];
			int midValue = array[mid];
			if (targetValue == midValue) {
				return mid;
			} 
			// left side sorted, right side unsorted
			if(startValue < midValue){
				if (targetValue >= startValue && targetValue < midValue) {
					return ModifiedBinarySearch(array, low, mid - 1, targetValue);
				}else{
					return ModifiedBinarySearch(array, mid + 1, high, targetValue);
				}
				// left side unsorted, right side sorted
			}else if(startValue > midValue){
				if(targetValue > midValue && targetValue <= endValue){
					return ModifiedBinarySearch(array, mid + 1, high, targetValue);
				}else{
					return ModifiedBinarySearch(array, low, mid - 1, targetValue);
				}
			}else{
				return -1;
			}
		}
		return -1;

	}

}
