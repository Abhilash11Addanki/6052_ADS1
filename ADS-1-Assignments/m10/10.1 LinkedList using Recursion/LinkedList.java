class Node {
	int data;
	Node link;
}
class LinkedList {
	Node head;
	int size;
	Node insert(Node head, int data, int pos) {
		if (pos == 0) {
			Node node = new Node();
			node.data = data;
			node.link = head;
			return node;
		}
		head.link = insert(head.link, data, pos - 1);
		return head;
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