package WhiteBoard;

import java.util.Arrays;

//Given an (MxN) matrix of integers, return an array in spiral order.
//
//Input: Array of integers
//Output: Array of integers
//Example
//Input: [[1,2,3],		=>	Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
//        [4,5,6],
//        [7,8,9]]      	
//Input: [[]]		=>	Output: []
//Constraints
//Time Complexity: O(MN)
//Auxiliary Space Complexity: O(MN)
//
//
//Values of the array will be digits 0-9.

public class SpiralMatrix {
	public static void main(String[] args) {
//		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] matrix = {{1, 2, 3, 4},{4, 3, 2, 1},{7, 6, 4, 8},{8, 7, 6, 1}};
		int[] output = new int[matrix[0].length * matrix.length];
		int minRow = 0;
		int maxRow = matrix.length - 1;
		int minCol = 0;
		int maxCol = matrix[0].length - 1;
		int k = 0;
		
		while(minRow <= maxRow && minCol <= maxCol){
			
			for(int i = minRow; i <= maxRow; ){
				for(int j = minCol; j <= maxCol; j ++){
					output[k] = matrix[i][j];
					 k ++;
				}
				break;
			}
			
			minRow ++;
			
			for(int i = maxCol; i >= minCol; ){
				for(int j = minRow ; j <= maxRow ; j ++){
					output[k] = matrix[j][i];
					k ++;
				}
				break;
			}
			
			maxCol --;
			
			for(int i = maxRow; i >= minRow; ){
				for(int j = maxCol; j >= minCol; j --){
					output[k] = matrix[i][j];
					k ++;
				}
				break;
			}
			
			maxRow --;
			
			for(int i = minCol; i <= maxCol; i ++){
				for(int j = maxRow; j >= minRow; j --){
					output[k] = matrix[j][i];
					k ++;
				}
				break;
			}
			
			minCol ++;
		}
		
		System.out.println(Arrays.toString(output));

	}
}
