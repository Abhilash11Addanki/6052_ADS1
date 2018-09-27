import java.util.Scanner;
import java.util.Arrays;
/**
 * Stack class which store the elements in the stack.
 */
class Stack {
	/**
	 * top variable to keep track of top element.
	 */
	private int top;
	/**
	 * arr of type String array which stores the elements.
	 */
	private String[] arr;
	/**
	 * n of type int which stores the size.
	 */
	private int n;
	/**
	 * Constructs the object.
	 * @param      size  The size
	 */
	Stack(final int size) {
		n = size;
		top = -1;
		arr = new String[n];
	}
	/**
	 * push method which pushes the element into stack.
	 * @param      x     element to be pushed.
	 */
	void push(final String x) {
		arr[++top] = x;
	}
	/**
	 * pop method which pops the element from stack.
	 * @return     element which is popped.
	 */
	String pop() {
		String ele = arr[top];
		top--;
		return ele;
	}
	/**
	 * Determines if empty.
	 * @return     True if empty, False otherwise.
	 */
	boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}
}
/**
 * Class for is balanced.
 */
class isBalanced {
	/**
	 * Determines if matching pair.
	 * @param      str1  The string 1
	 * @param      str2  The string 2
	 * @return     True if matching pair, False otherwise.
	 */
	boolean isMatchingPair(final String str1, final String str2) {
		if (str1.equals("(") && str2.equals(")")) {
			return true;
		}
		if (str1.equals("{") && str2.equals("}")) {
			return true;
		}
		if (str1.equals("[") && str2.equals("]")) {
			return true;
		}
		return false;
	}
	/**
	 * areBalanced method to check whether the parenthesis are balanced or not.
	 * @param      arr   The arr
	 * @return     True if balanced, False otherwise.
	 */
	boolean areBalanced(final String[] arr) {
		Stack st = new Stack(arr.length);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("{") || arr[i].equals("(") || arr[i].equals("[")) {
				st.push(arr[i]);
			}
			if (arr[i].equals("}") || arr[i].equals(")") || arr[i].equals("]")) {
				if (st.isEmpty()) {
					return false;
				}
				if (!isMatchingPair(st.pop(), arr[i])) {
					return false;
				}
			}
		}
		return st.isEmpty();
	}
}
/**
 * Class for solution.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * main method to drive the function.
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int noofinputs = Integer.parseInt(sc.nextLine());
		while (noofinputs != 0) {
			String line = sc.nextLine();
			String[] arr = line.split("");
			isBalanced b = new isBalanced();
			if (b.areBalanced(arr)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			noofinputs--;
		}
	}
}