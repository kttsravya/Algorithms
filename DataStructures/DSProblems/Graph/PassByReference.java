package Outco_DS4_Graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class PassByReference {
   public static void main(String[] args){
	   HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
	   int i = 1;
	   testPassByReference(map, i);
   }

private static void testPassByReference(HashMap<Integer, Integer> map, int i) {
	if(i == 10){
		map.put(i,i);
		return;
	}
	map.put(i,i);
	testPassByReference(map, i + 1);
	System.out.println("i value is " + i);
	Set<Integer> set = map.keySet();
	Iterator<Integer> it = set.iterator();
	while(it.hasNext()){
		System.out.print(it.next());
	}
	System.out.println();
	
}
}
