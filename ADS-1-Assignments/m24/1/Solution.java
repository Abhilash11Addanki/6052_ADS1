import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main method that drives the program.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        // Hash table to store the Roll Number and Student Name.
        SeparateChainingHashST<Integer, String> h1 =
        new SeparateChainingHashST();
        // Hash table to store the Roll Number and Marks of the Student.
        SeparateChainingHashST<Integer, Double> h2 =
        new SeparateChainingHashST();
        // No of inputs
        int n = Integer.parseInt(sc.nextLine());
        while (n-- != 0) {
            String[] inp = sc.nextLine().split(",");
            h1.put(Integer.parseInt(inp[0]), inp[1]);
            h2.put(Integer.parseInt(inp[0]), Double.parseDouble(inp[2]));
        }
        // No of testcases
        int testcases = Integer.parseInt(sc.nextLine());
        while (testcases-- != 0) {
            String[] tokens = sc.nextLine().split(" ");
            if (tokens[0].equals("get") && tokens[2].equals("1")) {
                if (h1.get(Integer.parseInt(tokens[1])) == null) {
                    System.out.println("Student doesn't exists...");
                } else {
                    System.out.println(h1.get(Integer.parseInt(tokens[1])));
                }
            } else if (tokens[0].equals("get") && tokens[2].equals("2")) {
                if (h2.get(Integer.parseInt(tokens[1])) == null) {
                    System.out.println("Student doesn't exists...");
                } else {
                    System.out.println(h2.get(Integer.parseInt(tokens[1])));
                }
            }
        }
    }
}
