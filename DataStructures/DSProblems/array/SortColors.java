package WhiteBoard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

//DS used: array, HashMap
//TimeComplexity : O(n)
//Auxiliary Space Complexity : O(1)

public class SortColors {
 public static void main(String[] args){
	 int[] array = {2, 0, 1, 2, 1, 0};
	 int[] solArray = sortColors(array);
	 System.out.println(Arrays.toString(solArray));
 }

private static int[] sortColors(int[] array) {
	int finalArrayIndex = 0;
	HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
	
	for(int i = 0; i < array.length; i ++){
		if(! map.containsKey(array[i])){
			map.put(array[i], 1);
		}else{
			int val = map.get(array[i]);
			map.put(array[i], val + 1 );
		}
	}
	
	Set<Integer> set = map.keySet();
	Iterator<Integer> it = set.iterator();
	
	while(it.hasNext()){
		int key = it.next();
		int val = map.get(key);
		int count = 0;
		while(count < val){
			array[finalArrayIndex] = key;
			count ++;
			finalArrayIndex ++;
		}
	}
	
	return array;

}
}
