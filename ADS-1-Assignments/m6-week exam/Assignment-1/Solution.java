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
        Node temp = list1.head;
        while (temp.link != null) {
            s1.push(temp.data);
            temp = temp.link;
        }
        s1.push(temp.data);
        Node temp1 = list2.head;
        while (temp1.link != null) {
            s2.push(temp1.data);
            temp1 = temp1.link;
        }
        s2.push(temp1.data);
        int result = 0, firstele = 0, secele = 0, temp2 = 0;
        final int ten = 10;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (s1.isEmpty()) {
                secele = Integer.parseInt(s2.pop());
                temp2 = result / ten;
                result = secele + temp2;
            } else if (s2.isEmpty()) {
                firstele = Integer.parseInt(s1.pop());
                temp2 = result / ten;
                result = firstele + temp2;
            } else {
                firstele = Integer.parseInt(s1.pop());
                secele = Integer.parseInt(s2.pop());
                temp2 = result / ten;
                result = firstele + secele + temp2;
            }
            res.insertAtStart(Integer.toString(result % ten));
        }
        if (s1.size == s2.size) {
            res.insertAtStart(Integer.toString(result / ten));
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
