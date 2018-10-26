import java.util.Scanner;
/**
 * Solution class.
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
     * Time complexity for this method is O(N log N)*
     * For some cases the time complexity may be O(M * N) where
     * M is for hash method and N is for while loop.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        LinearProbingHashST<String, Integer> lp = new LinearProbingHashST();
        int n = Integer.parseInt(sc.nextLine());
        while (n-- != 0) {
            String[] tokens = sc.nextLine().split(" ");
            switch (tokens[0]) {
            case "put":
                lp.put(tokens[1], Integer.parseInt(tokens[2]));
                break;
            case "get":
                System.out.println(lp.get(tokens[1]));
                break;
            case "delete":
                lp.delete(tokens[1]);
                break;
            case "display":
                String str = "{";
                for (String s : lp.keys()) {
                    str += (s + ":" + lp.get(s) + ", ");
                }
                str = str.replaceAll(", $", "");
                System.out.println(str + "}");
                break;
            default:
                break;
            }
        }
    }
}
