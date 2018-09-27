import java.util.Scanner;
import java.util.Arrays;
class Stack {
	private int top;
	private String[] arr;
	private int n;
	Stack(int size) {
		n = size;
		top = -1;
		arr = new String[n];
	}
	void push(String x) {
		if (top == n - 1) {
			System.out.println("Stack is full");
		} else {
			arr[++top] = x;
		}
	}
	String pop() {
		if (top == -1) {
			System.out.println("Underflow error");
			return null;
		}
		String ele = arr[top];
		top--;
		return ele;
	}
	boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}
}
class isBalanced {
	boolean isMatchingPair(String str1, String str2) {
		if (str1.equals('(') && str2.equals(')')) {
			return true;
		}
		if (str1.equals('{') && str2.equals('}')) {
			return true;
		}
		if (str1.equals('[') && str2.equals(']')) {
			return true;
		}
		return false;
	}
	boolean areBalanced(String[] arr) {
		Stack st = new Stack(arr.length);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals('{') || arr[i].equals('(') || arr[i].equals('[')) {
				st.push(arr[i]);
			}
			if (arr[i].equals('}') || arr[i].equals(')') || arr[i].equals(']')) {
				if (st.isEmpty()) {
					return false;
				} else if (!isMatchingPair(st.pop(), arr[i])) {
					return false;
				}
			}
		}
		if (st.isEmpty()) {
			return true;
		}
		return false;
	}
}
public class Solution {
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int noofinputs = Integer.parseInt(sc.nextLine());
		while (noofinputs != 0) {
			String line = sc.nextLine();
			String[] arr = line.split("");
			isBalanced b = new isBalanced();
			if (b.areBalanced(arr)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			noofinputs--;
		}
	}
}