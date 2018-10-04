import java.util.Scanner;
public class Solution {
	public static void main(String[] args) throws Exception {
		LinkedList l = new LinkedList();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] tokens = sc.nextLine().split(" ");
			switch (tokens[0]) {
			case "insertAt":
				if (Integer.parseInt(tokens[1]) < 0 || Integer.parseInt(tokens[1]) > l.size) {
					throw new Exception("Can't insert at this position");
				} else {
					l.insertAt(l.head, new Node(Integer.parseInt(tokens[2])),
						Integer.parseInt(tokens[1]), 0);
					l.display();
				}
				break;
			case "reverse":
				l.reverse(l.head, null);
				l.display();
				break;
			default:
				break;
			}
		}
	}
}