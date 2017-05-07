package WhiteBoard;

import java.util.Stack;

public class MinStack {
	public static Stack<Integer> values = new Stack<Integer>();
	public static Stack<Integer> min = new Stack<Integer>();

	public static void main(String[] args) {
		push(1);
		pop();
		peek();
		min();
	}

	private static int min() {
		return min.peek();
	}

	private static int peek() {
		return values.peek();
	}

	private static int pop() {
		min.pop();
		return values.pop();
	}

	private static void push(int value) {
		int minPeek = min.peek();
		if (value < minPeek) {
			min.push(value);
		} else {
			min.push(minPeek);
		}
		values.push(value);
	}
}
