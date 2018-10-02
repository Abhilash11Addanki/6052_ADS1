import java.util.Scanner;
/**
 * class Solution.
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
        Teams t = new Teams();
        while (sc.hasNext()) {
            String[] tokens = sc.nextLine().split(",");
            final int three = 3;
            t.add(new Team(tokens[0], Integer.parseInt(tokens[1]),
            Integer.parseInt(tokens[2]), Integer.parseInt(tokens[three])));
        }
        t.sort();
        System.out.println(t);
    }
}
