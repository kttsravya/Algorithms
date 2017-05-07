package WhiteBoard;

public class BinarySearch {
  public static void main(String[] args){
	  int[] array = {1, 16, 19, 27, 72, 86};
	 int index =  binarySearch(0, array.length - 1, 72, array);
	 System.out.println(index);
  }

private static int binarySearch(int low, int high, int target, int[] array) {
	if(low > high){
		return -1;
	}
	int mid = (low + high) / 2;
	if(array[mid] < target){
		return binarySearch(mid + 1, high, target, array);
	}
	else if (array[mid] > target){
		return binarySearch(low, mid - 1, target, array);
	}else {
		return mid;
	}
	
}
}
