import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < testcases; i++) {
			Steque<Integer> st = new Steque<Integer>();
			while (sc.hasNext()) {
				String tmp = sc.nextLine();
				if (tmp.equals("")) {
					break;
				}
				String[] tokens = tmp.split(" ");
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
}