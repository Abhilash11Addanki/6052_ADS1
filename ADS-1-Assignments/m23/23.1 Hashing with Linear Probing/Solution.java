import java.util.Scanner;
final class Solution {
	private Solution() {
	}
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		LinearProbingHashST<String, Integer> lp = new LinearProbingHashST();
		int n = Integer.parseInt(sc.nextLine());
		while (n-- != 0) {
			String[] tokens = sc.nextLine().split(" ");
			switch (tokens[0]) {
			case "put":
				lp.put(tokens[1], Integer.parseInt(tokens[2]));
				break;
			case "get":
				System.out.println(lp.get(tokens[1]));
				break;
			case "delete":
				lp.delete(tokens[1]);
				break;
			case "display":
				lp.display();
				break;
			}
		}
	}
}
