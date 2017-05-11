package WhiteBoard;

//Given an array of positive integers and a target value, return true if there is a subarray of consecutive elements that sum up to this target value. 
//
//Input: Array of integers, target value
//Output: Boolean
//Example
//Input: [6,12,1,7,5,2,3], 14      	=>	Output: true (7+5+2)
//Input: [8,3,7,9,10,1,13], 50		=>	Output: false
//Constraints
//Time Complexity: O(N)
//Auxiliary Space Complexity: O(1)
//All elements are positive

public class SubArraySum {
	public static void main(String[] args) {
		int[] array = { 1, 5, 4, 7, 5, 2, 256, 3 };
		int target = 3;

		boolean isTrue = findSubArray(array, target);
		System.out.println(isTrue);

	}

	private static boolean findSubArray(int[] array, int target) {
		int sum = 0;
		int startIndex = 0;
		int currentIndex = 0;
		for(int i = 0; i < array.length; i ++){
			sum = sum + array[i];
			currentIndex = i;
			if(sum > target){
				while(startIndex <= currentIndex && sum > target){
					sum = sum - array[startIndex];
					startIndex ++;
				}
			}
			if(sum == target){
				System.out.println("start index is " + startIndex);
				System.out.println("end index is " + currentIndex);
				return true;
			}
		}
		return false;
	}
}
