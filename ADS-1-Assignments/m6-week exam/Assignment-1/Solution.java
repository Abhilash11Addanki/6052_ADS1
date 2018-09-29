import java.util.Scanner;
import java.util.Scanner;
class LinkedList {
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
	private Node head;
	private Node tail;
	private int size;
	LinkedList() {
		head = null;
		tail = null;
		size = 0;
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
    	if (num[0].equals("0") && num.length == 1) {
    		list.insertAtEnd(num[0]);
    		return list;
    	}
    	for (int i = 0; i < num.length; i++) {
    		list.insertAtEnd(num[i]);
    	}
    	return list;
    }

    public static String digitsToNumber(LinkedList list) {
    	return list.ListToString();
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
    	return null;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
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
