class Node {
	int data;
	Node link;
}
class LinkedList {
	Node head;
	int size;
	void insertAtStart(int data) {
		Node node = new Node();
		size++;
		if (head == null) {
			node.data = data;
			node.link = head;
			head = node;
		} else {
			node.data = data;
			node.link = head;
			head = node;
		}
	}
	void insertAtPos(int pos, int data) {
		Node node = new Node();
		if (pos == 0) {
			insertAtStart(data);
			return;
		}
		pos--;
		Node temp = head;
		if (pos == 0) {
			return;
		} else {
			insertAtPos(pos, data);
			temp = temp.link;
		}
		node.data = data;
		node.link = temp.link;
		temp.link = node;
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