import java.util.Scanner;
import java.util.Arrays;
class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = sc.nextInt();
    }
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
    int search = sc.nextInt();
    System.out.println(binarySearch(arr, 0, arr.length - 1, search));
  }
  static int binarySearch(int[] arr, int start, int end, int search) {
    if (end >= start) {
      int mid = start + (end - start) / 2;
      if (arr[mid] == search)
        return mid;
      if (arr[mid] > search)
        return binarySearch(arr, start, mid - 1, search);
      return binarySearch(arr, mid + 1, end, search);
    }
    return -1;
  }
}