package WhiteBoard;

import java.util.ArrayList;
import java.util.Arrays;

import Outco_DS2_Trees.BinarySearchTree;
import Outco_DS2_Trees.Node;

public class LongestPathInBinaryTreeFromRootToLeaf {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		tree.insert(6);
		tree.insert(5);
		tree.insert(10);
		tree.insert(3);
		tree.insert(8);
		tree.insert(12);
		//tree.insert(24);
		Node root = tree.root;
		Node tempRoot = root;
		
		printLongestPathInBinaryTree(tempRoot);

		
	}

	

	private static void printLongestPathInBinaryTree(Node tempRoot) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		longestPathInBinaryTreeAfterGraphPractice(tempRoot, 0, al);
		int max = al.get(0);
		for(int i = 1; i < al.size(); i ++){
			if(al.get(i) > max){
				max = al.get(i);
			}
		}
		int[] path = new int[max];
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		printLongestPath(tempRoot, 0, path,al1);
		
	}


	private static void printLongestPath(Node tempRoot, int count, int[] path, ArrayList<Integer> al) {
		if(tempRoot == null){
			return;
		}
		path[count] = tempRoot.value;
		al.add(count, tempRoot.value);
		count ++;
		if(tempRoot.left != null){
			printLongestPath(tempRoot.left, count, path, al);
		}
		if(tempRoot.right != null){
			printLongestPath(tempRoot.right, count, path, al);
		}
		if(tempRoot.left == null && tempRoot.right == null){
			if(count == path.length){
				System.out.println(Arrays.toString(path));
				System.out.println("arraylist " +al.toString());
			}
		}
		
	}



	private static void longestPathInBinaryTreeAfterGraphPractice(Node tempRoot, int count, ArrayList<Integer> al) {
		if(tempRoot == null){
			return;
		}
		count ++;
		if(tempRoot.left != null){
			longestPathInBinaryTreeAfterGraphPractice(tempRoot.left, count, al);
		}
		if(tempRoot.right != null){
			 longestPathInBinaryTreeAfterGraphPractice(tempRoot.right, count, al);
		}
		if(tempRoot.left == null && tempRoot.right == null){
			al.add(count);
		}
	
	}



	private static void longestPathInBinaryTree(Node tempRoot) {
		int count = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		boolean sol = findLongestPath(tempRoot, count, list);
	
	// if sol returns false the following steps should be performed , else the given tree is empty	
		int max = list.get(0);
		for(int i = 0 ; i < list.size(); i ++){
			System.out.println(list.get(i));
			if(list.get(i) > max){
				max = list.get(i);
			}
		}
		
		System.out.println("max is " + max);
		
	}

	private static boolean findLongestPath(Node root, int count, ArrayList<Integer> list) {
	      if(root == null){
	    	  return true;
	      }
	    boolean a =  findLongestPath(root.left, count + 1, list);
	    
	    boolean b = findLongestPath(root.right, count + 1, list);
	    
	    if (a && b){
	    	list.add(count + 1);
	    	
	    }
		return false;
		
	}
}
