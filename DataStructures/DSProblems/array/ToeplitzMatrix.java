package WhiteBoard;

public class ToeplitzMatrix {
  
  public static void main(String[] args){
	  int[][] array = {{3, 4, 5, 6},{2, 3, 4, 5},{1, 2, 3, 4},{0, 1, 2, 3}};
	 boolean isTrue =  isToeplitzMatrix(array);
	 System.out.println(isTrue);
  }
// time comp: O(n^2)
 // space comp : O(1) 
private static boolean isToeplitzMatrix(int[][] array) {
	for(int i = 0; i < array[0].length; i ++){
		int value1 = array[0][i];
		 int z = i +1;
		for(int j = 1; j < array.length; j ++){
			 if(z < array[j].length){
				 int value2 = array[j][z];
				 z ++;
				 if(value1 != value2){
					 return false;
				 }
			 }
		}
	}
	
	for(int i = 0; i < array[0].length; i ++){
		int value1 = array[i][0];
		 int z = 1;
		for(int j = i + 1; j < array.length; j ++){
			 if(z < array[j].length){
				 int value2 = array[j][z];
				 z ++;
				 if(value1 != value2){
					 return false;
				 }
			 }
		}
	}
	return true;
	
}
   
}
