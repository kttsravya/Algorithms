package Outco_DS1;

public class LinkedListImp {
	 int length;
	 Node head;
	 Node tail;

	// append: a method that appends value at the end of the list
	// TimeComplexity: O(n)
	// Auxiliary SpaceComplexity: O(1)
	public  void append(int value) {
		Node newNode = new Node(value);

		if (length < 1) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		length++;
	}

	// insert: a method that inserts an integer value at a set index in the
	// linkedList,
	// assume head index is zero
	// TimeComplexity: O(n)
	// Auxiliary SpaceComplexity: O(1)
	public  void insert(int value, int index) {
		Node newNode = new Node(value);
		index = index + 1;

		if (index > length + 1 || index < 1) {
			System.out.println("index value is too high or too low");
			return;
		} else if (index == length + 1) { // append to the list
			append(value);
			return;
		} else if (index == 1) { // add at head
			if (length < 1) {
				head = tail = newNode;
			} else {
				newNode.next = head;
				head = newNode;
			}
		} else { // iterate through the list and insert value at given index
			int count = 1;
			Node tempHead = head;

			while (count + 1 < index) {
				tempHead = tempHead.next;
				count++;
			}
			if (index == length) { // add at tail
				tempHead.next = newNode;
				newNode.next = tail;
			} else {
				Node nextNode = tempHead.next;
				tempHead.next = newNode;
				newNode.next = nextNode;
			}

		}
		length++;

	}

	// delete: a method that removes node at a specified index
	// assume head index is zero
	// TimeComplexity:O(n)
	// Auxiliary SpaceComplexity:O(1)
	public  void delete(int index) {
		index = index + 1;

		if (index < 1 || index > length) {
			System.out.println("given index is too high or too low");
			return;
		} else if (index == 1) { // delete head
			if (length == 1) {
				head = tail = null;
			} else {
				head = head.next;
			}
		} else{
			int count = 1;
			Node tempHead = head;

			while (count + 1 < index) {
				tempHead = tempHead.next;
				count++;
			}
			if (index == length) { // add at tail
				tail = tempHead;
			} else {
				Node nextNode = tempHead.next.next;
				tempHead.next = nextNode;
			}
		}
		length--;

	}

	// contains: a method that checks to see if a value is contained in the
	// list.
	// TimeComplexity:O(n)
	// Auxiliary SpaceComplexity:O(1)
	public  boolean contains(int value) {
		Node tempHead = head;
		while (tempHead != null) {
			if (tempHead.value == value) {
				return true;
			}
			tempHead = tempHead.next;
		}
		return false;
	}

//	public static void main(String[] args) {
//		
//		insert(1, 0);
//		insert(2, 1);
//		insert(3, 2);
//		insert(4, 3);
//		append(6);
//		insert(5, 4);
//		append(7);
//		append(8);
//		insert(9, 8);
//		append(10);
//		append(11);
//		insert(-1, 9);
//		delete(5);// delete element at index 6
//		insert(6,5);
//		delete(11); // delete last element
//		append(11);
//		delete(0);
//		printList();
//		System.out.println(contains(11));
//	}

	public void printList() {
		Node tempHead = head;
		while (tempHead != null) {
			System.out.println(tempHead.value);
			tempHead = tempHead.next;
		}

	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}
	

}

//class Node {
//	int value;
//	Node next;
//
//	public Node(int value) {
//		this.value = value;
//	}
//
//}
