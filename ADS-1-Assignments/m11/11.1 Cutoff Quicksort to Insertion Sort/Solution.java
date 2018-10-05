import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		QuickSort qs = new QuickSort();
		int testcases = Integer.parseInt(sc.nextLine());
		while (testcases != 0) {
			int cutoff = Integer.parseInt(sc.nextLine());
			String[] arr = sc.nextLine().split("");
			qs.sort(arr, 0, arr.length, cutoff);
			qs.printArray(arr);
			testcases--;
		}
	}
}