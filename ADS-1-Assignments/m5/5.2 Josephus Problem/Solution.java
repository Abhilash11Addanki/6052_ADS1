import java.util.Scanner;
/**
 * Class for josephus.
 */
class Josephus {
    /**
     * Calculates the josephus.
     * @param      n     number of members
     * @param      m     mth person
     */
    void calculateJosephus(final int n, final int m) {
        CircularLinkedList c = new CircularLinkedList();
        for (int i = 0; i < n; i++) {
            c.add(i);
        }
        String str = "";
        while (!c.isEmpty()) {
            int t1 = 0;
            for (int i = 0; i < m; i++) {
                t1 = c.getNext();
            }
            str += c.remove(t1) + " ";
        }
        System.out.println(str.trim());
    }
}
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
        Josephus j = new Josephus();
        Scanner sc = new Scanner(System.in);
        int testcases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testcases; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            j.calculateJosephus(n, m);
        }
    }
}
