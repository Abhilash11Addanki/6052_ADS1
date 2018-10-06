import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noofstudents = Integer.parseInt(sc.nextLine());
		int noofvacancies = Integer.parseInt(sc.nextLine());
		int noofunreversedcat = Integer.parseInt(sc.nextLine());
		int noofbccat = Integer.parseInt(sc.nextLine());
		int noofsccat = Integer.parseInt(sc.nextLine());
		int noofstcat = Integer.parseInt(sc.nextLine());
		Students s = new Students(noofstudents);
		while (noofstudents != 0) {
			String[] arr = sc.nextLine().split(",");
			arr[1] = arr[1].split("-")[2];
			s.add(new StudentInfo(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]),
				Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), Integer.parseInt(arr[5]),
				arr[6]));
			noofstudents--;
		}
		s.sort();
		s.show();
	}
}