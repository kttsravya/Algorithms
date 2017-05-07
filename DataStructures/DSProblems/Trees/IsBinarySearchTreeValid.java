package WhiteBoard;


import Outco_DS2_Trees.BinaryTree;
import Outco_DS2_Trees.Node;

public class IsBinarySearchTreeValid {
  public static void main(String[] args){
	BinaryTree binaryTree = new BinaryTree();
	
	// true tree
	
//	binaryTree.insert(5);
//	binaryTree.insert(2);
//	binaryTree.insert(7);
//	binaryTree.insert(1);
//	binaryTree.insert(3);
	
	// false tree
	
	binaryTree.insert(5);
	binaryTree.insert(2);
	binaryTree.insert(7);
	binaryTree.insert(1);
	binaryTree.insert(6);
	
	Node root = binaryTree.root;
	Node tempRoot = root;
	
	int min = Integer.MIN_VALUE;
	int max = Integer.MAX_VALUE;
	
	boolean isValid = isValidBSTOrNot(tempRoot, min, max);
	System.out.println(isValid);
	
  }

private static boolean isValidBSTOrNot(Node root, int min, int max) {
	if(root == null){
		return true;
	}
	
	if(root.value < min || root.value > max){
		return false;
	}
	
	return isValidBSTOrNot(root.left, min, root.value) && isValidBSTOrNot(root.right, root.value, max);
	
}
}
