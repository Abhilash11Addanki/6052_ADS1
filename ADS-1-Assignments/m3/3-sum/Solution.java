import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		int cnt = 0;
		for (int i = 0; i < size - 2; i++) {
			int j = i + 1;
			int k = i + 1;
			while (j < size - 1) {
				while (k < size) {
					if (arr[i] + arr[j] + arr[k] == 0) {
						cnt++;
						break;
					}
					k++;
				}
				j++;
			}
		}
		System.out.println(cnt);
	}
}