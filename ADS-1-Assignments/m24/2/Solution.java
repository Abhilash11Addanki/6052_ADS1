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
        BinarySearchTree<Student, String> h =
            new BinarySearchTree();
        int n = Integer.parseInt(sc.nextLine());
        while (n-- != 0) {
            String[] inp = sc.nextLine().split(",");
            h.put(new Student(inp[0], inp[1],
                Double.parseDouble(inp[2])), inp[0]);
        }
        int testcases = Integer.parseInt(sc.nextLine());
        while (testcases-- != 0) {
            String[] tokens = sc.nextLine().split(" ");
            switch (tokens[0]) {
            case "BE":
                for (Student s : h.keys()) {
                    if (s.getTotalMarks() >= Double.parseDouble(tokens[1])
                    && s.getTotalMarks() <= Double.parseDouble(tokens[2])) {
                        System.out.println(s.getStudentName());
                    }
                }
                break;
            case "GE":
                for (Student s : h.keys()) {
                    if (s.getTotalMarks() >= Double.parseDouble(tokens[1])) {
                        System.out.println(s.getStudentName());
                    }
                }
                break;
            case "LE":
                for (Student s : h.keys()) {
                    if (s.getTotalMarks() <= Double.parseDouble(tokens[1])) {
                        System.out.println(s.getStudentName());
                    }
                }
                break;
            default:
                break;
            }
        }
    }
}
