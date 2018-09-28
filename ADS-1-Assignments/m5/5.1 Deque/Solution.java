import java.util.Scanner;
class Deque<E> {
	LinkedList<E> l = new LinkedList<E>();
	boolean isEmpty() {
		return l.isEmpty();
	}
	int size() {
		return l.getsize();
	}
	void pushLeft(E data) {
		l.insertAtStart(data);
	}
	void pushRight(E data) {
		l.insertAtEnd(data);
	}
	void popLeft() {
		l.deleteAtPos(1);
	}
	void popRight() {
		l.deleteAtPos(l.getsize());
	}
	void display() {
		l.display();
	}
}
public class Solution {
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> d = new Deque<Integer>();
		int n = Integer.parseInt(sc.nextLine());
		while (n != 0) {
			String line = sc.nextLine();
			String[] tokens = line.split(" ");
			switch (tokens[0]) {
			case "isEmpty":
				System.out.println(d.isEmpty());
				break;
			case "size":
				System.out.println(d.size());
				break;
			case "pushLeft":
				d.pushLeft(Integer.parseInt(tokens[1]));
				d.display();
				break;
			case "pushRight":
				d.pushRight(Integer.parseInt(tokens[1]));
				d.display();
				break;
			case "popLeft":
				d.popLeft();
				d.display();
				break;
			case "popRight":
				d.popRight();
				d.display();
				break;
			default:
				break;
			}
			n--;
		}
	}
}