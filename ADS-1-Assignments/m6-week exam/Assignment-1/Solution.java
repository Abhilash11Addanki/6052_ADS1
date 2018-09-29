import java.util.Scanner;
/**
 * Class for node.
 */
class Node {
    /**
     * data of type String.
     */
    private String data;
    /**
     * next that stores address of other node.
     */
    private Node next;
    /**
     * Constructs the object.
     * @param      d     data.
     * @param      n     next.
     */
    Node(final String d, final Node n) {
        data = d;
        next = n;
    }
    /**
     * gets the data.
     * @return     data.
     */
    String getdata() {
        return data;
    }
    /**
     * sets the data.
     * @param      d     data.
     */
    void setdata(final String d) {
        data = d;
    }
    /**
     * gets the next node address.
     * @return     next.
     */
    Node getnext() {
        return next;
    }
    /**
     * sets the next node address.
     * @param      n     next.
     */
    void setnext(final Node n) {
        next = n;
    }
}
/**
 * Linked List class.
 */
class LinkedList {
    /**
     * head node.
     */
    private Node head;
    /**
     * tail node.
     */
    private Node tail;
    /**
     * size to keep track of size of node.
     */
    private int size;
    /**
     * Constructs the object.
     */
    LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    /**
     * gets the head.
     * @return     head.
     */
    Node gethead() {
        return head;
    }
    /**
     * gets the tail.
     * @return     tail.
     */
    Node gettail() {
        return tail;
    }
    /**
     * Determines if empty.
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
        return head == null;
    }
    /**
     * gets the size.
     * @return     size.
     */
    int getsize() {
        return size;
    }
    /**
     * inserts data at the end.
     * @param      data  The data
     */
    void insertAtEnd(final String data) {
        Node first = new Node(data, null);
        size++;
        if (head == null) {
            head = first;
            tail = head;
        } else {
            tail.setnext(first);
            tail = first;
        }
    }
    /**
     * inserts data at the start.
     * @param      data  The data
     */
    void insertAtStart(final String data) {
        Node first = new Node(data, null);
        size++;
        if (head == null) {
            head = first;
            tail = head;
        } else {
            first.setnext(head);
            head = first;
        }
    }
    /**
     * converts the linked list to String.
     * @return     string str
     */
    String listtoString() {
        String str = "";
        if (head.getnext() == null) {
            str += head.getdata();
            return str;
        }
        Node first = head;
        str += head.getdata();
        first = head.getnext();
        while (first.getnext() != null) {
            str += first.getdata();
            first = first.getnext();
        }
        str += first.getdata();
        return str;
    }
}
/**
 * Class for add large numbers.
 */
class AddLargeNumbers {
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
        LinkedList list = new LinkedList();
        Node first = list1.gethead();
        Node second = list2.gethead();
        String firstele = Integer.toString(Integer.parseInt(list1.gethead().getdata())
                + Integer.parseInt(list2.gethead().getdata()));
        String digit = "";
        if (firstele.length() >= 2) {
            digit += firstele.split("")[0];
            list.insertAtStart(firstele.split("")[1]);
        } else {
            list.insertAtStart(firstele);
        }
        first = list1.gethead().getnext();
        second = list2.gethead().getnext();
        String digit1 = "";
        while (first.getnext() != null && second.getnext() != null) {
            String secele = Integer.toString(Integer.parseInt(first.getdata())
            + Integer.parseInt(second.getdata() + Integer.parseInt(digit)));
            digit1 = "";
            if (secele.length() >= 2) {
                digit1 += secele.split("")[0];
                list.insertAtStart(secele.split("")[1]);
            } else {
                list.insertAtStart(secele);
            }
            first = first.getnext();
            second = second.getnext();
        }
        list.insertAtStart(Integer.toString(Integer.parseInt(first.getdata())
            + Integer.parseInt(second.getdata()) + Integer.parseInt(digit1)));
        return list;
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



