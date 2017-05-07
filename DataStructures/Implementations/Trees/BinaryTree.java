package Outco_DS2_Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

// all operations in this class is performed assuming tree is complete binary tree
// complete binary tree: is a tree which is completely filled with possible exception 
// at the bottom level

public class BinaryTree {

	public  Node root = null;

//	public static void main(String[] args) {
//		// insert(value) - add elements at the end of the complete binary tree
//		// do breath first traversal, to add new node to the older node with one
//		// or no child
//		insert(1);
//		insert(2);
//		insert(3);
//		insert(4);
//		insert(5);
//		insert(6);
//
//		// search(value)
////		boolean isPresent = search(5);
////		System.out.println(" isPresent " + isPresent);
//
//		// delete() - deletes element from the end of the complete binary tree
//
//		// delete();
//		// delete();
//
//  // traversals - breadth and depth first search traversals
//
//	// breadth first search traversal
//		breadthFirstSearchTraversal(root);
//
//	// depth first search traversal - inorder
//		Node tempRoot = root;
//		inorderRecursive(tempRoot);
//		inorder(tempRoot);
//
//	// depth first search traversal - preorder
//		 preOrderRecursive(tempRoot);
//		 preOrder(tempRoot);
//		
//
//	// depth first search traversal - postorder
//		 postOrderRecursive(tempRoot);
//		 postOrder(tempRoot);
//		 
//   // print all paths in a binary tree from top to bottom
//		 ArrayList<Node> list = new ArrayList<Node>();
//		 printAllPaths(tempRoot,list,0);
//	}
   
	public void printAllPaths(Node tempRoot, ArrayList<Node> list,int position) {
		if(tempRoot == null){
			return;
		}
		list.add(position,tempRoot);
		position ++;
		if(tempRoot.left == null && tempRoot.right == null){
			print(list,position);
		}
		else{
			printAllPaths(tempRoot.left, list, position);
			printAllPaths(tempRoot.right, list, position);
		}
		
	}

	public void print(ArrayList<Node> list, int position) {
		for(int i=0; i< position; i ++){
			System.out.print("print all paths" +list.get(i).value +" ");
			
		}
		System.out.println();
	}

	// post order traversal logic is 
	// get sequence of (root - right - left) and reverse sequence and output it..
	public void postOrder(Node tempRoot) {
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		System.out.println("reverse order of postOrder is printed and reverse order elements"
				+ "are also stored in stack2 when pop elements from stack2 it gives correct output");
		while(tempRoot != null){
			stack2.push(tempRoot);
			System.out.println("reverse postOrder " +tempRoot.value);
			stack1.push(tempRoot);
			tempRoot = tempRoot.right;
		}
		 while(! stack1.isEmpty()){
			 Node poppedElement = stack1.pop();
			 if(poppedElement.left != null){
				 Node current = poppedElement.left;
				 while(current != null){
					 stack2.push(current);
					 System.out.println("reverse postOrder " +current.value);
					 stack1.push(current);
					 current = current.right;
				 }
			 }
		 }
		 
		 // this stack2 prints correct post order traversal sequence.
		 printStack(stack2);
		
		
	}
     
	public void printStack(Stack<Node> stack2) {
		while( ! stack2.isEmpty()){
			System.out.println("post order " +stack2.pop().value);
		}
		
	}

	public void postOrderRecursive(Node tempRoot) {
		if(tempRoot != null){
			postOrderRecursive(tempRoot.left);
		}
		if(tempRoot != null){
			postOrderRecursive(tempRoot.right);
		}
		if(tempRoot != null){
			System.out.println("postOrderRecursive " +tempRoot.value);
		}
		
	}

	public void preOrder(Node tempRoot) {
		Stack<Node> stack = new Stack<Node>();
	   while(tempRoot != null){
		   System.out.println("preorder " +tempRoot.value);
		   stack.push(tempRoot);
		   tempRoot = tempRoot.left;   
	   }
	   while( ! stack.isEmpty()){
		   Node poppedElement = stack.pop();
		   if(poppedElement.right != null){
			   Node current = poppedElement.right;
			   while(current !=  null){
				   System.out.println("preorder " +current.value);
				   stack.push(current);
				   current = current.left;
			   }
		   }
	   }
		
	}

	public void preOrderRecursive(Node tempRoot) {
		if(tempRoot != null){
			System.out.println("pre order recursive " +tempRoot.value);
		}
		if(tempRoot != null){
			preOrderRecursive(tempRoot.left);
		}
		if(tempRoot != null){
			preOrderRecursive(tempRoot.right);
		}
	}

	public void inorder(Node tempRoot) {
		Stack<Node> stack = new Stack<Node>();
		while(tempRoot != null){
			stack.push(tempRoot);
			tempRoot = tempRoot.left;
		}
		while( !stack.isEmpty()){
			Node poppedNode = stack.pop();
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

	// time complexity : O(n) - going through all the elements in the tree to find search node
	public boolean search(int i) {
		Node tempRoot = root;
		return search(i, tempRoot);

	}

	private static boolean search(int i, Node tempRoot) {
		if (tempRoot != null && tempRoot.value == i) {
			return true;
		}

		if (tempRoot != null) {
			return search(i, tempRoot.left) || search(i, tempRoot.right);
		}

		return false;

	}

	// time complexity - O(n)
	public void inorderRecursive(Node tempRoot) {
		if (tempRoot != null) {
			inorderRecursive(tempRoot.left);
		}
		if (tempRoot != null) {
			System.out.println("inorder recursive " +tempRoot.value);
		}

		if (tempRoot != null) {
			inorderRecursive(tempRoot.right);
		}
	}

	// time complexity : O(n) - > n+ n = 2n = n
	// first n for to find element to be deleted which is younger node
	// second n is for traveling to end of the tree through breadth first search
	public void delete() {
		Stack<Node> stack = new Stack<Node>();
		Node tempRoot = root;
		if (tempRoot == null) {
			System.out.println("tree is empty");
			return;
		} else {
			LinkedList<Node> queue = new LinkedList<Node>();
			queue.add(tempRoot);
			stack.push(tempRoot);
			while (!queue.isEmpty()) {
				Node current = queue.remove();
				stack.push(current);
				if (current.left != null) {
					queue.add(current.left);
				}
				if (current.right != null) {
					queue.add(current.right);
				}

			}
		}
		Node elementAddress = stack.pop();
		delete(elementAddress);

	}

	public void delete(Node elementAddress) {
		Node tempRoot = root;
		if (tempRoot == null || tempRoot == elementAddress) {
			root = null;
			return;
		} else {
			LinkedList<Node> queue = new LinkedList<Node>();
			queue.add(tempRoot);
			while (!queue.isEmpty()) {
				Node current = queue.remove();
				if (current.left != null) {
					if (current.left != elementAddress) {
						queue.add(current.left);
					} else {
						current.left = null;
					}
				}
				if (current.right != null) {
					if (current.right != elementAddress) {
						queue.add(current.right);
					} else {
						current.right = null;
					}

				}

			}
		}

	}

	// TimeComplexity : O(n) - traversing through all nodes
	public void breadthFirstSearchTraversal(Node root) {
		Node tempRoot = root;
		if (tempRoot == null) {
			System.out.println("tree is empty");
			return;
		} else {
			LinkedList<Node> queue = new LinkedList<Node>();
			queue.add(tempRoot);
			System.out.println(tempRoot.value);
			while (!queue.isEmpty()) {
				Node current = queue.remove();
				if (current.left != null) {
					queue.add(current.left);
					System.out.println(current.left.value);
				}
				if (current.right != null) {
					queue.add(current.right);
					System.out.println(current.right.value);
				}
			}
		}

	}

	// TimeComplexity : O(n)
	// because traversing through all the nodes when doing breadth first search
	// to add
	// element at the end of the tree to make it as complete binary tree.
	public void insert(int i) {
		Node newNode = new Node(i);
		Node tempRoot = root;
		if (root == null) {
			root = newNode;
			return;
		} else {
			// linked list to act like queue, insert at tail, remove from head
			LinkedList<Node> queue = new LinkedList<Node>();
			queue.add(tempRoot);
			while (!queue.isEmpty()) {
				Node current = queue.remove();
				if (current.left != null) {
					queue.add(current.left);
				} else {
					current.left = newNode;
					return;
				}

				if (current.right != null) {
					queue.add(current.right);
				} else {
					current.right = newNode;
					return;
				}
			}
		}

	}
}

//class Node {
//	int value;
//	Node left;
//	Node right;
//
//	public Node(int value) {
//		this.value = value;
//	}
//}
