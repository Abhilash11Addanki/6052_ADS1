class Node {
	String data;
	Node link;
}
class LinkedList {
	Node head;
	int size;
	void insertAtStart(String data) {
		Node node = new Node();
		size++;
		if (head == null) {
			node.data = data;
			node.link = null;
			head = node;
		} else {
			node.data = data;
			node.link = head;
			head = node;
		}
	}
	void insertAtEnd(String data) {
		Node node = new Node();
		size++;
		if (head == null) {
			node.data = data;
			node.link = null;
			head = node;
		} else {
			Node temp = head;
			while (temp.link != null) {
				temp = temp.link;
			}
			node.data = data;
			temp.link = node;
			node.link = null;
		}
	}
	void insertAtPos(String data, int pos) {
		Node node = new Node();
		if (pos == 0) {
			return;
		}
		if (pos == 1) {
			insertAtStart(data);
			return;
		}
		pos--;
		Node temp = head;
		while (pos != 1) {
			temp = temp.link;
			pos--;
		}
		node.data = data;
		node.link = temp.link;
		temp.link = node;
		size++;
	}
	void deleteAtStart() {
		Node node = new Node();
		Node temp = head;
		temp = temp.link;
		head.link = null;
		head = temp;
		size--;
	}
	void deleteAtEnd() {
		Node node = new Node();
		Node temp = head;
		while (temp.link.link != null) {
			temp = temp.link;
		}
		temp.link = null;
		size--;
	}
	void deleteAtPos(int pos) {
		if (pos == 0) return;
		if (pos == 1) {
			deleteAtStart();
			return;
		}
		pos--;
		Node temp = head;
		while (pos != 1) {
			temp = temp.link;
			pos--;
		}
		temp.link = temp.link.link;
		size--;
	}
	String listtoString() {
		String str = "";
		if (head.link == null) {
			str += head.data;
			return str;
		}
		Node first = head;
		str += head.data;
		first = head.link;
		while (first.link != null) {
			str += first.data;
			first = first.link;
		}
		str += first.data;
		return str;
	}
}