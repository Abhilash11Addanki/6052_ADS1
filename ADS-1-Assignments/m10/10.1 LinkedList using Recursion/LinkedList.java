class Node {
	int data;
	Node link;
}
class LinkedList {
	Node head;
	int size;
	Node insert(int pos, int data) {
		int cnt = 0;
		Node node = new Node();
		if (head == null) {
			return head;
		}
		Node temp = head;
		while (temp.link != null) {
			if (cnt == pos) {
				break;
			}
			temp = temp.link;
			cnt++;
		}
		temp.link = insert(cnt, data);
		return temp;
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