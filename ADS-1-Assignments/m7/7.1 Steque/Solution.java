import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Steque<Integer> st = new Steque<Integer>();
		int testcases = Integer.parseInt(sc.nextLine());
		while (testcases-- != 0) {
			String[] tokens = sc.nextLine().split(" ");
			switch (tokens[0]) {
			case "push":
				st.push(Integer.parseInt(tokens[1]));
				st.display();
				break;
			case "pop":
				st.pop();
				st.display();
				break;
			case "enqueue":
				st.insertAtEnd(Integer.parseInt(tokens[1]));
				st.display();
				break;
			default:
				break;
			}
		}
	}
}