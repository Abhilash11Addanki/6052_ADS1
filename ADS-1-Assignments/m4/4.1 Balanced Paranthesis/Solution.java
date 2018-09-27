import java.util.Scanner;
import java.util.Arrays;
class Stack {
	private int top;
	private String[] arr;
	private int n;
	Stack(int size) {
		n = size;
		top = 0;
		arr = new String[n];
	}
	void push(String x) {
		arr[top++] = x;

	}
	String pop() {
		if (top == 0) {
			System.out.println("Underflow error");
			return null;
		}
		String ele = arr[top];
		top--;
		return ele;
	}
	boolean isEmpty() {
		if (top == 0) {
			return true;
		}
		return false;
	}
}
class isBalanced {
	boolean isMatchingPair(String str1, String str2) {
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
	boolean areBalanced(String[] arr) {
		Stack st = new Stack(arr.length);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("{") || arr[i].equals("(") || arr[i].equals("[")) {
				st.push(arr[i]);
			} else if (arr[i].equals("}") || arr[i].equals(")") || arr[i].equals("]")) {
				if (st.isEmpty()) {
					return false;
				}
				if (!isMatchingPair(st.pop(), arr[i])) {
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
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			noofinputs--;
		}
	}
}