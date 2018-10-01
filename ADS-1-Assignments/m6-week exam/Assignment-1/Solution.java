import java.util.Scanner;
/**
 * Class for add large numbers.
 */
final class AddLargeNumbers {
    /**
     * Constructs the object.
     */
    private AddLargeNumbers() {

    }
    /**
     * converts numbers to digits.
     * @param      number  The number
     * @return     linked list
     */
    public static LinkedList numberToDigits(final String number) {
        LinkedList list = new LinkedList();
        String[] num = number.split("");
        for (int i = 0; i < num.length; i++) {
            list.insertAtEnd(num[i]);
        }
        return list;
    }
    /**
     * converts digits to numbers.
     * @param      list  The list
     * @return     String
     */
    public static String digitsToNumber(final LinkedList list) {
        return list.listtoString();
    }
    /**
     * Adds large numbers.
     * @param      list1  The list 1
     * @param      list2  The list 2
     * @return     Linked list.
     */
    public static LinkedList addLargeNumbers(final LinkedList list1,
            final LinkedList list2) {
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        LinkedList res = new LinkedList();
        while (list1.head.link != null) {
            s1.push(list1.head.data);
            list1.head = list1.head.link;
        }
        while (list2.head.link != null) {
            s2.push(list2.head.data);
            list2.head = list2.head.link;
        }
        while (s1.isEmpty() && s2.isEmpty()) {
            int firstele = Integer.parseInt(s1.pop());
            int secele = Integer.parseInt(s2.pop());
            int result = firstele + secele;
            res.insertAtStart(Integer.toString(result % 10));
            result += result / 10;
        }
        return res;
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
     * main method that drives the program.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits,
                                qDigits);
            System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        default:
            break;
        }
    }

}






