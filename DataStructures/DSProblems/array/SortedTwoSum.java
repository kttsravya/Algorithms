package WhiteBoard;

import java.util.Arrays;

// DS used: array
// time complexity : O(n)
// space complexity : O(1)

public class SortedTwoSum {
  public static void main(String[] args){
	  int[] array = {-5, 1, 3, 6, 7};
	  int target = 13;  
	  int[] sol1 = sortedTwoSum(array, target);
	  System.out.println(Arrays.toString(sol1));
  }

private static int[] sortedTwoSum(int[] array, int target) {
	 int i = 0;
	 int j = array.length - 1;
	 while(i < j){
		 if(array[i] + array[j] > target){
			 j = j - 1;
		 }else if (array[i] + array[j] < target){
			 i = i + 1;
		 }else{
			 int[] sol = new int[2];
			 sol[0] = i;
			 sol[1] = j;
			 return sol;
		 }
	 }
	 
	 int[] sol = new int[2];
	 sol[0] = -1;
	 sol[1] = -1;
	 return sol;
}
}
