public class MinPQ<Key extends Comparable<Key>> {
	MinPQ() {
	}
	public void isMinHeap(final Key[] arr) {
		int k = arr.length - 1;
		while(k > 1) {
			if (arr[k].compareTo(arr[k / 2]) >= 0) {
				k--;
			} else {
				System.out.println("false");
				return;
			}
		}
		System.out.println("true");
	}
}
