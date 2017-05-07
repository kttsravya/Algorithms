package WhiteBoard;

import java.util.ArrayList;

import java.util.Iterator;




public class LowestCommonAncestor {
	public static void main(String[] args) {

		Node root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(7);
		root.right.left = new Node(4);
		root.right.right = new Node(8);
		root.right.right.right = new Node(9);
		root.right.left.left = new Node(12);

		Node tempRoot = root;
		 /*// for search 2 method
		int[] array = null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		search2(tempRoot, 9, array, list);
		
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			System.out.println("home method" + it.next());
		}*/
		
		
		// for search3 method
		
		/*ArrayList<Integer> array1 = new ArrayList<Integer>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		search3(tempRoot, 9, array1, list1);
		
		Iterator<Integer> it1 = list1.iterator();
		while (it1.hasNext()) {
			System.out.println("home method" + it1.next());
		}*/
		
		// for search 4 method
		ArrayList<Integer> array1 = new ArrayList<Integer>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		search4(tempRoot, 9, array1, list1);
		
		Iterator<Integer> it1 = list1.iterator();
		while (it1.hasNext()) {
			System.out.println("home method" + it1.next());
		}
		
		

		//lowestCommonAncestor(tempRoot, 4, 9);

	}

	private static void lowestCommonAncestor(Node tempRoot, int value1, int value2) {

		int[] array = null;
		int size = 0;

		ArrayList<Integer> finalList = new ArrayList<Integer>();

		search(tempRoot, value1, array, size, finalList);

		ArrayList<Integer> finalList1 = new ArrayList<Integer>();

		search(tempRoot, value2, array, size, finalList1);

		Iterator<Integer> it = finalList.iterator();
		while (it.hasNext()) {
			System.out.println("home method" + it.next());
		}

		Iterator<Integer> it1 = finalList1.iterator();
		while (it1.hasNext()) {
			System.out.println("home method2" + it1.next());
		}
		

// the following code snippet may be wrong or may be right.
		int i = 1;
		for(i = 1; i < finalList.size() && i < finalList1.size(); i ++){
			if (finalList.get(i) != finalList1.get(i)){
				System.out.println(finalList.get(i - 1));
				return;
			}
		}
		System.out.println("i is " + i);
		if(i >= finalList.size()){
			System.out.println(finalList.get(finalList.size() - 1));
			return;
		}else{
			System.out.println(finalList.get(finalList1.size() - 1));
			return;
		}
	   
		

		

	}

	private static boolean search(Node tempRoot, int value1, int[] array, int size, ArrayList<Integer> list) {
		//System.out.println("search method called");
		if (tempRoot == null) {
			//System.out.println("never came here");
			return false;
		}
		if (tempRoot.value == value1) {
			//System.out.println("final iteration");
			for (int i = 0; i < array.length; i++) {
				//System.out.println(array[i]);
				list.add(array[i]);
			}
			return true;
		}

		int[] array1 = new int[size + 1];
		if (array == null) {
			array1[0] = tempRoot.value;

		} else {
			for (int i = 0; i < size; i++) {
				array1[i] = array[i];
				//System.out.print(" array1 " + array1[i] + " ");
			}
			array1[size] = tempRoot.value;
			//System.out.println(array1[size]);
		}

		return (tempRoot.left != null && search(tempRoot.left, value1, array1, size + 1, list))
				|| (tempRoot.right != null && search(tempRoot.right, value1, array1, size + 1, list));

	}

	// same method as search with out size argument
	public static boolean search2(Node tempRoot, int value1, int[] array, ArrayList<Integer> list) {
		System.out.println("current element is " + tempRoot.value);
		if(array != null){
			for(int i = 0; i< array.length; i ++){
				System.out.println(array[i]);
			}
		}
//		if (tempRoot == null) {
//			return false;
//		}
		if (tempRoot.value == value1) {
			
			for (int i = 0; i < array.length; i++) {
				
				list.add(array[i]);
			}
			return true;
		}
		int[] array1 = null;
		if (array == null) {
			array1 = new int[1];
			array1[0] = tempRoot.value;

		} else {
			array1 = new int[array.length + 1];
			for (int i = 0; i < array.length; i++) {
				array1[i] = array[i];
				
			}
			array1[array1.length - 1] = tempRoot.value;
			
		}

		return (tempRoot.left != null && search2(tempRoot.left, value1, array1, list))
				|| (tempRoot.right != null && search2(tempRoot.right, value1, array1, list));

	}
	
	public static boolean search3(Node tempRoot, int value1, ArrayList<Integer> array, ArrayList<Integer> list) {
		System.out.println("current element is " + tempRoot.value);
		if(array != null){
			for(int i = 0; i< array.size(); i ++){
				System.out.println(array.get(i));
			}
		}
//		if (tempRoot == null) {
//			return false;
//		}
		if (tempRoot.value == value1) {
			
			for (int i = 0; i < array.size(); i++) {
				
				list.add(array.get(i));
			}
			return true;
		}
//		int[] array1 = null;
//		if (array == null) {
//			array1 = new int[1];
//			array1[0] = tempRoot.value;
//
//		} else {
//			array1 = new int[array.length + 1];
//			for (int i = 0; i < array.length; i++) {
//				array1[i] = array[i];
//				
//			}
//			array1[array1.length - 1] = tempRoot.value;
		
			
//		}
	    array.add(tempRoot.value);

		return (tempRoot.left != null && search3(tempRoot.left, value1, array, list))
				|| (tempRoot.right != null && search3(tempRoot.right, value1, array, list));

	}
	
	public static boolean search4(Node tempRoot, int value1, ArrayList<Integer> array, ArrayList<Integer> list) {
		System.out.println("current element is " + tempRoot.value);
		if(array != null){
			for(int i = 0; i< array.size(); i ++){
				System.out.println(array.get(i));
			}
		}
		
//		if (tempRoot == null) {
//			return false;
//		}
		if (tempRoot.value == value1) {
			
			for (int i = 0; i < array.size(); i++) {
				
				list.add(array.get(i));
			}
			return true;
		}
//		int[] array1 = null;
//		if (array == null) {
//			array1 = new int[1];
//			array1[0] = tempRoot.value;
//
//		} else {
//			array1 = new int[array.length + 1];
//			for (int i = 0; i < array.length; i++) {
//				array1[i] = array[i];
//				
//			}
//			array1[array1.length - 1] = tempRoot.value;
		
			
//		}
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i = 0; i < array.size(); i ++){
			al.add(i,array.get(i));
		}
	    al.add(array.size(),tempRoot.value);

		return (tempRoot.left != null && search3(tempRoot.left, value1, al, list))
				|| (tempRoot.right != null && search3(tempRoot.right, value1, al, list));

	}


}

class Node {
	int value;
	Node left;
	Node right;

	public Node(int value) {
		this.value = value;
	}
}
