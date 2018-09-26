import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size1 = Integer.parseInt(sc.nextLine());
		int size2 = Integer.parseInt(sc.nextLine());
		String[] arr1 = sc.nextLine().split(",");
		String[] arr2 = sc.nextLine().split(",");
		int[] array1 = new int[arr1.length];
		int[] array2 = new int[arr2.length];
		if (arr1[0].equals("")) {
			array1 = new int[0];
		}
		for (int i = 0; i < array1.length; i++) {
			array1[i] = Integer.parseInt(arr1[i]);
		}
		for (int j = 0; j < array2.length; j++) {
			array2[j] = Integer.parseInt(arr2[j]);
		}
		mergesort(array1, array2);
	}
	public static void mergesort(int[] arr1, int[] arr2) {
		int i = 0, j = 0;
		int[] result = new int[arr1.length + arr2.length];
		for (int k = 0; k < result.length; k++) {
			if (i < arr1.length && j < arr2.length) {
				if (arr1[i] < arr2[j]) {
					result[k] = arr1[i++];
				} else {
					result[k] = arr2[j++];
				}
			} else if (i >= arr1.length) {
				result[k] = arr2[j++];
			} else if (j >= arr2.length) {
				result[k] = arr1[i++];
			}
		}
		System.out.println(Arrays.toString(result).replace("[", "").replace("]", "").replace(" ", ""));
	}
}