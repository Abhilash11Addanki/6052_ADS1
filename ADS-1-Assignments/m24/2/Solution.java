import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SeparateChainingHashST<Double, String> h =
		    new SeparateChainingHashST();
		int n = Integer.parseInt(sc.nextLine());
		while (n-- != 0) {
			String[] inp = sc.nextLine().split(",");
			h.put(Double.parseDouble(inp[2]), inp[1]);
		}
		int testcases = Integer.parseInt(sc.nextLine());
		while (testcases-- != 0) {
			String[] tokens = sc.nextLine().split(" ");
			switch (tokens[0]) {
			case "BE":
				for (Double marks : h.keys()) {
					if (marks >= Double.parseDouble(tokens[1]) && marks <= Double.parseDouble(tokens[2])) {
						System.out.println(h.get(marks));
					}
				}
				break;
			case "LE":
				for (Double marks : h.keys()) {
					if (marks <= Double.parseDouble(tokens[1])) {
						System.out.println(h.get(marks));
					}
				}
				break;
			case "GE":
				for (Double marks : h.keys()) {
					if (marks >= Double.parseDouble(tokens[1])) {
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
