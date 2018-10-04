import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] tokens = sc.nextLine().split(" ");
			switch (tokens[0]) {
			case "insertAt":
				if (Integer.parseInt(tokens[1]) < 0 || Integer.parseInt(tokens[1]) > l.size) {
					System.out.println("Can't insert at this position.");
				} else {
					l.insert(l.head, Integer.parseInt(tokens[2]), Integer.parseInt(tokens[1]));
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