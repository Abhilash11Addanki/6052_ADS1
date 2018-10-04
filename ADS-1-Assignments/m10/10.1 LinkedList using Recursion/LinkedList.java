class Node {
	int data;
	Node link;
}
class LinkedList {
	Node head;
	int size;
	void insertAtPos(int pos, int data) {
		Node node = new Node();
		node.data = data;
		Node temp = head;
		pos--;
		int curind = 0;
		if (curind == pos) {
			Node node1 = temp;
			temp.link = node;
			node.link = node1;
		} else {
			curind = curind + 1;
			insertAtPos(curind, data);
			temp = temp.link;
		}
		size++;
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