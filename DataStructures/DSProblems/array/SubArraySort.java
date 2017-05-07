package WhiteBoard;

// TimeCom : O(n)
// Space Com :O(1)

public class SubArraySort {
   public static void main(String[] args){
	   //int[] array = {3, 4, 8, 7, 20, 6, 17};
	   int[] array = {3, 4, 8, 7, 10, 6, 17};
	   subArraySort(array);
   }

private static void subArraySort(int[] array) {
	int start = -1;
	int end = -1;
	for(int i = 0; i < array.length - 1; i ++){
		if(array[i + 1] < array[i]){
			start = i + 1;
			break;
		}
	}
	System.out.println("start is " + start);
	for(int i = array.length - 1; i > 0; i --){
		if(array[i - 1] > array[i]){
			end = i - 1;
			break;
		}
	}
	System.out.println("end is " + end);
	int min = array[start];
	int max = array[end];
	
	if(start <= end){
		for(int i = start; i <= end; i ++){
			if(array[i] < min){
				min = array[i];
			}	
		}
		
		for(int i = start; i <=end; i ++){
			if(array[i] > max){
				max = array[i];
			}
		}
		System.out.println("min is " +min);
		System.out.println("max is " +max);
	}
	
	for(int i =0; i < start; i ++){
		if(array[i] > min){
			start = i;
		}
	}
	for(int i = array.length - 1; i >= end ; i --){
		if(array[i] < max){
			end = i;
		}
	}
	
	System.out.println(start + " " + end);
	
	
}
}
