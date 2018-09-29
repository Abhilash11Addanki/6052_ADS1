import java.util.Scanner;
import java.util.Scanner;
class Node {
	private String data;
	private Node next;
	Node(final String d, final Node n) {
		data = d;
		next = n;
	}
	String getdata() {
		return data;
	}
	void setdata(final String d) {
		data = d;
	}
	Node getnext() {
		return next;
	}
	void setnext(final Node n) {
		next = n;
	}
}
class LinkedList {
	private Node head;
	private Node tail;
	private int size;
	LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	Node gethead() {
		return head;
	}
	Node gettail() {
		return tail;
	}
	boolean isEmpty() {
		return head == null;
	}
	int getsize() {
		return size;
	}
	void insertAtEnd(String data) {
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
	String ListToString() {
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

class AddLargeNumbers {

	public static LinkedList numberToDigits(String number) {
		LinkedList list = new LinkedList();
		String[] num = number.split("");
		for (int i = 0; i < num.length; i++) {
			list.insertAtEnd(num[i]);
		}
		return list;
	}

	public static String digitsToNumber(LinkedList list) {
		return list.ListToString();
	}

	public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
		LinkedList list = new LinkedList();
		Node first = list1.gethead();
		Node second = list2.gethead();
		list.insertAtEnd(Integer.toString(Integer.parseInt(list1.gethead().getdata())
			+ Integer.parseInt(list2.gethead().getdata())));
		first = list1.gethead().getnext();
		second = list2.gethead().getnext();
		while (first.getnext() != null && second.getnext() != null) {
			list.insertAtEnd(Integer.toString(Integer.parseInt(first.getdata())
				+ Integer.parseInt(second.getdata())));
			first = first.getnext();
		}
		list.insertAtEnd(Integer.toString(Integer.parseInt(first.getdata())
			+ Integer.parseInt(second.getdata())));
		return list;
	}
}

public class Solution {
	public static void main(String[] args) {
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
			LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
			System.out.println(AddLargeNumbers.digitsToNumber(result));
			break;
		}
	}

}
