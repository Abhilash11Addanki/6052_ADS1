import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main method to drive the program.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
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
            s.add(new StudentInfo(arr[0], year, month, date,
            	Integer.parseInt(arr[2]),
            Integer.parseInt(arr[3]), Integer.parseInt(arr[4]),
            Integer.parseInt(arr[5]), arr[6]));
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
        StudentInfo[] reservstu = new StudentInfo[noofvacancies
        - noofunreversedcat];
        int sizee = 0;

        for (int i = cnt; i < noofstudents; i++) {
            if (noofbccat == 0 || noofstcat == 0
            	|| noofsccat == 0 || noofvacancies == 0) {
                break;
            }
            if (s.arr[i].reservationcat.equals("BC")) {
                reservstu[sizee++] = s.show(i);
                noofvacancies--;
                noofbccat--;
            } else if (s.arr[i].reservationcat.equals("ST")) {
                reservstu[sizee++] = s.show(i);
                noofvacancies--;
                noofstcat--;
            } else if (s.arr[i].reservationcat.equals("SC")) {
                reservstu[sizee++] = s.show(i);
                noofvacancies--;
                noofsccat--;
            } else if (s.arr[i].reservationcat.equals("Open")) {
                reservstu[sizee++] = s.show(i);
                noofvacancies--;
            }
        }
        Arrays.sort(reservstu, Collections.reverseOrder());
        for (StudentInfo stuu : reservstu) {
            System.out.println(stuu);
        }
    }
}

