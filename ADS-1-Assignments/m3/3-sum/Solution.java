import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int cnt = 0;
		for (int i = 0; i < size - 2; i++) {
			int j = i + 1;
			int k = j + 1;
			if (arr[i] + arr[j] + arr[k] == 0) {
				cnt++;
				j++;
				k++;
			}
		}
		System.out.println(cnt);
	}
}