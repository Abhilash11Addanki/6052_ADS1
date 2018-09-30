import java.util.Scanner;
class Josephus {
	void CalculateJosephus(int n, int m) {
		CircularLinkedList c = new CircularLinkedList();
		for (int i = 0; i < n; i++) {
			c.add(i);
		}
		String str = "";
		while (!c.isEmpty()) {
			int t2 = 0;
			for (int i = 0; i < m; i++) {
				t2 = c.getNext();
			}
			str += c.remove(t2) + " ";
		}
		System.out.println(str.trim());
	}
}
public class Solution {
	public static void main(final String[] args) {
		Josephus j = new Josephus();
		Scanner sc = new Scanner(System.in);
		int testcases = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < testcases; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			j.CalculateJosephus(n, m);
		}
	}
}