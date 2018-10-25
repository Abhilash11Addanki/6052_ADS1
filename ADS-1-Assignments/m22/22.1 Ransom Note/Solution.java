import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] inp = sc.nextLine().split(" ");
		int m = Integer.parseInt(inp[0]);
		int n = Integer.parseInt(inp[1]);
		String[] magazine = sc.nextLine().split(" ");
		String[] note = sc.nextLine().split(" ");
		SeparateChainingHashST<String, Integer> mag = new SeparateChainingHashST<String, Integer>();
		SeparateChainingHashST<String, Integer> notes = new SeparateChainingHashST<String, Integer>();
		for (int i = 0; i < m; i++) {
			mag.put(magazine[i], i);
		}
		int cnt = 0;
		for (String s : note) {
			if (mag.contains(s)) {
				cnt++;
			}
		}
		if (cnt == n) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
