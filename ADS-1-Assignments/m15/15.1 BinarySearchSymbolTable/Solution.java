import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		BinarySearchST<String, Integer> bs = new BinarySearchST<String, Integer>(input.length);
		for (int i = 0; i < input.length; i++) {
			bs.put(input[i], i);
		}
		while (sc.hasNext()) {
			String[] tokens = sc.nextLine().split(" ");
			switch (tokens[0]) {
			case "max":
				System.out.println(bs.max());
				break;
			default:
				break;
			}
		}
	}
}