import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SeparateChainingHashST<Integer, String> h =
		    new SeparateChainingHashST();
		int n = Integer.parseInt(sc.nextLine());
		while (n-- != 0) {
			String[] inp = sc.nextLine().split(",");
			h.put(Integer.parseInt(inp[0]), inp[1]);
		}
		int testcases = Integer.parseInt(sc.nextLine());
		while (testcases-- != 0) {
			String[] tokens = sc.nextLine().split(" ");
			switch (tokens[0]) {
			case "BE":
				for (Integer marks : h.keys()) {
					if (marks >= Integer.parseInt(tokens[1]) && marks <= Integer.parseInt(tokens[2])) {
						System.out.println(h.get(marks));
					}
				}
				break;
			case "LE":
				for (Integer marks : h.keys()) {
					if (marks <= Integer.parseInt(tokens[1])) {
						System.out.println(h.get(marks));
					}
				}
				break;
			case "GE":
				for (Integer marks : h.keys()) {
					if (marks >= Integer.parseInt(tokens[1])) {
						System.out.println(h.get(marks));
					}
				}
				break;
			default:
				break;
			}
		}
	}
}