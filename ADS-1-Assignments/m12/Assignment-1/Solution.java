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
		int n = noofstudents;
		Students s = new Students(noofstudents);
		while (n != 0) {
			String[] arr = sc.nextLine().split(",");
			int year = Integer.parseInt(arr[1].split("-")[2]);
			int month = Integer.parseInt(arr[1].split("-")[1]);
			int date = Integer.parseInt(arr[1].split("-")[0]);
			s.add(new StudentInfo(arr[0], year, month, date, Integer.parseInt(arr[2]),
			                      Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), Integer.parseInt(arr[5]),
			                      arr[6]));
			n--;
		}
		s.sort();
		for (int i = 0; i < noofstudents; i++) {
			System.out.println(s.show(i));
		}
		System.out.println();
		int cnt = 0;
		for (int i = 0; i < noofstudents; i++) {
			if (noofunreversedcat == 0) {
				break;
			}
			System.out.println(s.show(i));
			noofvacancies--;
			noofunreversedcat--;
			cnt++;
		}
		for (int i = cnt; i < noofstudents; i++) {
			if (noofbccat == 0) {
				break;
			}
			if (s.arr[i].reservationcat.equals("BC")) {
				System.out.println(s.show(i));
				noofvacancies--;
				noofbccat--;
			}
		}
		for (int i = cnt; i < noofstudents; i++) {
			if (noofvacancies == 0) {
				break;
			}
			if (s.arr[i].reservationcat.equals("Open")) {
				System.out.println(s.show(i));
				noofvacancies--;
			}
		}
		for (int i = cnt; i < noofstudents; i++) {
			if (noofstcat == 0) {
				break;
			}
			if (s.arr[i].reservationcat.equals("ST")) {
				System.out.println(s.show(i));
				noofvacancies--;
				noofstcat--;
			}
		}
		for (int i = cnt; i < noofstudents; i++) {
			if (noofsccat == 0) {
				break;
			}
			if (s.arr[i].reservationcat.equals("SC")) {
				System.out.println(s.show(i));
				noofvacancies--;
				noofsccat--;
			}
		}
	}
}