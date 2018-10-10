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
			case "floor":
				System.out.println(bs.floor(tokens[1]));
				break;
			case "rank":
				System.out.println(bs.rank(tokens[1]));
				break;
			case "deleteMin":
				bs.deleteMin();
				break;
			case "contains":
				System.out.println(bs.contains(tokens[1]));
				break;
			case "keys":
				for (String s: bs.keys()) {
					System.out.println(s + " " + Integer.toString(bs.rank(s)));
				}
				//System.out.println(bs.keys());
				break;
			case "get":
			System.out.println(bs.get(tokens[1]));
				break;
			default:
				break;
			}
		}
	}
}