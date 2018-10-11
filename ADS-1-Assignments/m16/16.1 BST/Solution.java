import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinarySearchTree<Book, Integer> bst = new BinarySearchTree();
		while (sc.hasNext()) {
			String[] tokens = sc.nextLine().split(",");
			switch (tokens[0]) {
			case "put":
				Book key = new Book(tokens[1], tokens[2], Double.parseDouble(tokens[2 + 1]));
				int value = Integer.parseInt(tokens[2 + 2]);
				bst.put(key, value);
				break;
			case "get":
				key = new Book(tokens[1], tokens[2], Double.parseDouble(tokens[2 + 1]));
				System.out.println(bst.get(key));
				break;
			default:
				break;
			}
		}
	}
}