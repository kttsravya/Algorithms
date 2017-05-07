package WhiteBoard;

import Outco_DS2_Trees.BinarySearchTree;
import Outco_DS2_Trees.Node;

public class ValidBinarySearchTree {
  public static void main(String[] args){
	  BinarySearchTree tree = new BinarySearchTree();

//		tree.insert(6);
//		tree.insert(5);
//		tree.insert(10);
//		tree.insert(3);
//		tree.insert(8);
//		tree.insert(12);
		//tree.insert(24);
		
		
//		tree.insert(5);
//		tree.insert(2);
//		tree.insert(7);
//		tree.insert(4);
//		tree.insert(9);
		
		
		
		Node root = tree.root;
		Node tempRoot = root;
		tree.preOrderRecursive(tempRoot);
		boolean sol = isValid(tempRoot);
		System.out.println(sol);
  }

private static boolean isValid(Node tempRoot) {
	if(tempRoot == null){
		return true;
	}
	if(tempRoot.left != null){
		if(tempRoot.left.value > tempRoot.value){
			return false;
		}
	}
	
	if(tempRoot.right != null){
		if(tempRoot.right.value < tempRoot.value){
			return false;
		}
	}
	return isValid(tempRoot.left) && isValid(tempRoot.right);
	
}
}
