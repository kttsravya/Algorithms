package WhiteBoard;

import java.util.ArrayList;
import java.util.Stack;

import Outco_DS2_Trees.BinarySearchTree;
import Outco_DS2_Trees.Node;

// Time comp : O(n)
// Space comp: O(n)

public class KthLargestInBinarySearchTree {
 public static void main(String[] args){
	 BinarySearchTree bst = new BinarySearchTree();
	 bst.insert(20);
	 bst.insert(8);
	 bst.insert(22);
	 bst.insert(4);
	 bst.insert(12);
	 bst.insert(10);
	 bst.insert(14);
	 
	Node root = bst.root;
	Node tempRoot = root; 
	ArrayList<Integer> list = new ArrayList<Integer>();
	inorder(tempRoot,list);
	
	int k = 2;
	int size = list.size();
	System.out.println("kth largest element is " +list.get(size - k ));
 }
 
 public static void inorder(Node tempRoot,ArrayList<Integer> list) {
		Stack<Node> stack = new Stack<Node>();
		while(tempRoot != null){
			stack.push(tempRoot);
			tempRoot = tempRoot.left;
		}
		while( !stack.isEmpty()){
			Node poppedNode = stack.pop();
			list.add(poppedNode.value);
			System.out.println("inorder " +poppedNode.value);
			if(poppedNode.right != null){
				Node current = poppedNode.right;
				while(current != null){
					stack.push(current);
					current = current.left;
				}
			}
		}
	}
}
