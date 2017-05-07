package Outco_DS2_Trees;

public class BinarySearchTree {
	public  Node root;

//	public static void main(String[] args) {
//
//		// insert
//		// tree1
//		// insert(6);
//		// insert(5);
//		// insert(10);
//		// insert(3);
//		// insert(8);
//		// insert(12);
//
//		// tree2
//		insert(30);
//		insert(18);
//		insert(48);
//		insert(12);
//		insert(24);
//		insert(16);
//		insert(20);
//		insert(37);
//		insert(56);
//		insert(42);
//		insert(50);
//
//		// delete
//		Node tempRoot = root;
//		Node parent = null;
//		System.out.println("befor deletion");
//		preOrderRecursive(tempRoot);
//		delete(tempRoot, 100, parent);
//		System.out.println("after deletion");
//		preOrderRecursive(tempRoot);
//
//	// search
//		// boolean isPresent = search(3);
//		// System.out.println("isPresent " + isPresent);
////		boolean isPresent = searchRecursive(tempRoot, 50);
////		System.out.println("search recursive " + isPresent);
//	
//
//		// print preorder tree
//		// tempRoot = root;
//		// preOrderRecursive(tempRoot);
//
//	}
	
	

	private  boolean searchRecursive(Node tempRoot, int i) {
		if(tempRoot == null || tempRoot.value == i){
			return true;
		}
		if(i < tempRoot.value && tempRoot.left != null){
			return searchRecursive(tempRoot.left, i);
		}
		if(i > tempRoot.value && tempRoot.right != null){
			return searchRecursive(tempRoot.right, i);
		}else{
			return false;
		}
		
	}

	private  void delete(Node tempRoot, int i, Node parent) {
		// Node parent = null;
		if (tempRoot == null) {
			return;
		} else {
			// in while loop we are finding deletable value and
			// and reference to parent of deletable value is set to parent(Node
			// parent)
			while (tempRoot != null) {
				if (tempRoot.value == i) {
					// parent = null;
					break;
				} else if (i < tempRoot.value && tempRoot.left != null) {
					if (tempRoot.left.value == i) {
						parent = tempRoot;
						tempRoot = tempRoot.left;
						break;
					} else {
						tempRoot = tempRoot.left;
					}
				} else if (i > tempRoot.value && tempRoot.right != null) {
					if (tempRoot.right.value == i) {
						parent = tempRoot;
						tempRoot = tempRoot.right;
						break;
					} else {
						tempRoot = tempRoot.right;
					}
				} else if ((i > tempRoot.value && tempRoot.right == null)
						|| (i < tempRoot.value && tempRoot.left == null)) {
					System.out.println("given value is not present in tree, so cant delete");
					return;
				}
			}

			
			// now tempRoot has deletable value
			// so check if deletable value has 0 1 or 2 childs and perform
			// operations accordingly

			// checking if deletable value has no children
			if (tempRoot.left == null && tempRoot.right == null) {
				// if parent == null means deletable value is root of the tree
				if (parent != null) {
					if (parent.left == tempRoot) {
						parent.left = null;
					} else if (parent.right == tempRoot) {
						parent.right = null;
					}
				} else {
					root = null;
				}
			} else if (tempRoot.left != null || tempRoot.right != null) {
				// if left child of deletable value is not null, find max in
				// left subtree and replace deletable
				// value with max value
				if (tempRoot.left != null) {
					int replacableValue = findMax(tempRoot.left);
					tempRoot.value = replacableValue;
					// after delete max value of left child, so send root as
					// tempRoot.left;
					parent = tempRoot;
					delete(tempRoot.left, replacableValue, parent);
				} else if (tempRoot.right != null) {
					int replacableValue = findMin(tempRoot.right);
					tempRoot.value = replacableValue;
					// after delete min value of left child, so send root as
					// tempRoot.right;
					delete(tempRoot.right, replacableValue, parent);
				}
			}
		}

	}

	private  int findMin(Node right) {
		while (right.left != null) {
			right = right.left;
		}
		return right.value;
	}

	private  int findMax(Node left) {
		while (left.right != null) {
			left = left.right;
		}
		return left.value;

	}

	private boolean search(int i) {
		Node tempRoot = root;
		while (tempRoot != null) {
			if (tempRoot.value == i) {
				return true;
			} else if (i <= tempRoot.value) {
				tempRoot = tempRoot.left;
			} else {
				tempRoot = tempRoot.right;
			}
		}
		return false;

	}

	public void insert(int i) {
		Node newNode = new Node(i);
		Node tempRoot = root;

		if (root == null) {
			root = newNode;
			return;
		} else {
			while (tempRoot != null) {
				if (i <= tempRoot.value && tempRoot.left != null) {
					tempRoot = tempRoot.left;
				} else if (i <= tempRoot.value && tempRoot.left == null) {
					tempRoot.left = newNode;
					return;
				} else if (i > tempRoot.value && tempRoot.right != null) {
					tempRoot = tempRoot.right;
				} else {
					tempRoot.right = newNode;
					return;
				}
			}
		}
	}

	public  void preOrderRecursive(Node tempRoot) {
		if (tempRoot != null) {
			System.out.println("pre order recursive " + tempRoot.value);
		}
		if (tempRoot != null) {
			preOrderRecursive(tempRoot.left);
		}
		if (tempRoot != null) {
			preOrderRecursive(tempRoot.right);
		}
	}
}
