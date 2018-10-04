import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] tokens = sc.nextLine().split(" ");
			switch(tokens[0]) {
				case "insertAt":
				l.insertAtPos(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
				l.display();
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