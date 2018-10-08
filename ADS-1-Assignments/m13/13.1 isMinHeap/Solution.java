import java.util.Scanner;
public final class Solution {
	private Solution() {
	}
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		String datatype = sc.nextLine();
		int testcases = Integer.parseInt(sc.nextLine());
		switch(datatype) {
			case "String":
			while(testcases-- != 0) {
				String[] arr = sc.nextLine().split(",");
				String[] strarr = new String[arr.length + 1];
				for (int j = 0; j < strarr.length - 1; j++) {
					strarr[j + 1] = arr[j];
				}
				MinPQ<String> pq = new MinPQ<String>();
				pq.isMinHeap(strarr);
			}
			break;
			case "Integer":
			while(testcases-- != 0) {
				String[] arr = sc.nextLine().split(",");
				Integer[] intarr = new Integer[arr.length + 1];
				for (int j = 0; j < intarr.length - 1; j++) {
					intarr[j + 1] = Integer.parseInt(arr[j]);
				}
				MinPQ<Integer> pq = new MinPQ<Integer>();
				pq.isMinHeap(intarr);
			}
			break;
			case "Float":
			while(testcases-- != 0) {
				String[] arr = sc.nextLine().split(",");
				Float[] floatarr = new Float[arr.length + 1];
				for (int j = 0; j < floatarr.length - 1; j++) {
					floatarr[j + 1] = Float.parseFloat(arr[j]);
				}
				MinPQ<Float> pq = new MinPQ<Float>();
				pq.isMinHeap(floatarr);
			}
			break;
			case "Double":
			while(testcases-- != 0) {
				String line = sc.nextLine();
				if (line.equals("")) {
					System.out.println("false");
					break;
				}
				String[] arr = line.split(",");
				Double[] doublearr = new Double[arr.length + 1];
				for (int j = 0; j < doublearr.length - 1; j++) {
					doublearr[j + 1] = Double.parseDouble(arr[j]);
				}
				MinPQ<Double> pq = new MinPQ<Double>();
				pq.isMinHeap(doublearr);
			}
			break;
			default:
			break;
		}
	}
}
