import java.util.Scanner;
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
     * main method.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        LinkedList l = new LinkedList();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] tokens = sc.nextLine().split(" ");
            switch (tokens[0]) {
            case "insertAt":
                try {
                    l.head = l.insertAt(l.head,
                        new Node(Integer.parseInt(tokens[2])),
                        Integer.parseInt(tokens[1]), 0);
                    l.size++;
                    l.display();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "reverse":
                l.reverse(l.head, null);
                l.display();
                break;
            default:
                break;
            }
        }
    }
}
