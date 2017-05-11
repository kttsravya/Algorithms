package WhiteBoard;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
 public static void main(String[] args){
	 int[] duplicateArray = {1, 2, 2, 2, 3, 9, 9 };
	 removeDuplicates(duplicateArray);
	 System.out.println(Arrays.toString(duplicateArray));;
 }

private static void removeDuplicates(int[] duplicateArray) {
	int unique = 0;
	for(int i = duplicateArray.length - 1; i >= 1; i --){
		if(duplicateArray[i] == duplicateArray[i - 1]){
			duplicateArray[i] = -1;
		}else{
			System.out.println(i);
			unique ++;
		}
	}
	if(duplicateArray[1] != -1){
		
		unique ++;
	}
	
	System.out.println("unique count" + unique);
	
}
}
