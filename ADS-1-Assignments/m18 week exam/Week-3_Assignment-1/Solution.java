import java.util.Scanner;
import java.util.Arrays;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfStocks = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < 6 * noOfStocks; i++) {
			String[] input = sc.nextLine().split(",");
			System.out.println(Arrays.toString(input));
		}
	}
}