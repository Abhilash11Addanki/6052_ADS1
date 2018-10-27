import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SeparateChainingHashST<Integer, String> h1 = new SeparateChainingHashST();
		SeparateChainingHashST<Integer, Double> h2 = new SeparateChainingHashST();
		int n = Integer.parseInt(sc.nextLine());
		while (n-- != 0) {
			String[] inp = sc.nextLine().split(",");
			h1.put(Integer.parseInt(inp[0]), inp[1]);
			h2.put(Integer.parseInt(inp[0]), Double.parseDouble(inp[2]));
		}
		int testcases = Integer.parseInt(sc.nextLine());
		while (testcases-- != 0) {
			String[] tokens = sc.nextLine().split(" ");
			if (tokens[0].equals("get") && tokens[2].equals("1")) {
				if (h1.get(Integer.parseInt(tokens[1])) == null) {
					System.out.println("Student doesn't exists...");
				} else {
					System.out.println(h1.get(Integer.parseInt(tokens[1])));
				}
			} else if (tokens[0].equals("get") && tokens[2].equals("2")) {
				if (h2.get(Integer.parseInt(tokens[1])) == null) {
					System.out.println("Student doesn't exists...");
				} else {
					System.out.println(h2.get(Integer.parseInt(tokens[1])));
				}
			}
		}
	}
}
