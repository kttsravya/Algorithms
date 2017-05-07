package WhiteBoard;

// DS Used: array
// Algo Used: modified BinarySearch
// TimeCOmplexity: O(log n)
// Space COmplexity : O(1)
// recursive way

public class NumberOfOnes {
  public static void main(String[] args){
	  int[] array = {0, 0, 0, 0, 1,1};
	  int val = numberOfOnes(0,array.length - 1, array);
	  if(val == -1){
		  System.out.println("no ones");
	  }else{
		  System.out.println(val);
	  }
	 
  }

private static int numberOfOnes(int low, int high,int[] array) {
	if(low > high){
		return -1;
	}
	int mid = (low + high)/2;
	if(array[mid] == 1 && mid - 1 >=0 && array[mid - 1] != 0){
		return numberOfOnes(low, mid - 1, array);
	}else if (array[mid] == 1 && mid - 1 >=0 && array[mid - 1] == 0){
		return array.length - mid;
	}else if (array[mid] == 0 && mid + 1 < array.length && array[mid + 1] != 1){
		return numberOfOnes(mid + 1, high, array);
	}else if (array[mid] == 0 && mid + 1 < array.length && array[mid + 1] == 1){
		return array.length - (mid + 1);
	}else{
		return -1;
	}
	
}
}
