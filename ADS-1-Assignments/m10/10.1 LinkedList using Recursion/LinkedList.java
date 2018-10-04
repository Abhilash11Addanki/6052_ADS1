class Node {
	int data;
	Node link;
	Node(int d) {
		data = d;
	}
}
class LinkedList {
	Node head;
	int size;
	Node insertAt(Node cur, Node newNode, int pos, int curPos) {
		if (pos < 0 || pos > size) {
			System.out.println("Can't insert at this position.");
			return null;
		}
		if (cur == null) {
			return newNode;
		} else if (curPos == pos) {
			newNode.link = cur;
			return newNode;
		}
		cur.link = insertAt(cur.link, newNode, pos, curPos + 1);
		return cur;
	}
	Node reverse(Node cur, Node prev) {
		if (cur == null) {
			return null;
		}
		if (cur.link == null) {
			head = cur;
			cur.link = prev;
			return head;
		}
		Node next = cur.link;
		cur.link = prev;
		reverse(next, cur);
		return head;
	}
	void display() {
		if (size == 0) {
			System.out.println("No elements to reverse.");
			return;
		}
		if (head.link == null) {
			System.out.println(head.data);
			return;
		}
		Node temp = head;
		while (temp.link != null) {
			System.out.print(temp.data + ", ");
			temp = temp.link;
		}
		System.out.println(temp.data);
	}
}