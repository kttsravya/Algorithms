package WhiteBoard;

import Outco_DS2_Trees.BinarySearchTree;
import Outco_DS2_Trees.Node;

public class InvertABinaryTree {
   public static void main(String[] args){
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
		tree.preOrderRecursive(tempRoot);
		invert(tempRoot);
		System.out.println();
		tree.preOrderRecursive(tempRoot);
   }

private static void invert(Node tempRoot) {
	if(tempRoot == null){
		return;
	}
	
	Node temp = tempRoot.left;
	tempRoot.left = tempRoot.right;
	tempRoot.right = temp;
	
	invert(tempRoot.left);
	invert(tempRoot.right);
}
}
