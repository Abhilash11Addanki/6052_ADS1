class LinkedList<E> {
	class Node {
		E data;
		Node link;
	}
	Node head;
	int size;
	void insertAtStart(E data) {
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
	void insertAtEnd(E data) {
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
	void insertAtPos(int pos, E data) {
		Node node = new Node();
		if (pos < 0 || pos > size) {
			System.out.println("Can't insert at this position.");
			return;
		}
		if (pos == 0) {
			insertAtStart(data);
			return;
		}
		if (pos == size) {
			insertAtEnd(data);
			return;
		}
		pos--;
		Node temp = head;
		if (pos != 0) {
			insertAtPos(pos, data);
			temp = temp.link;
		}
		node.data = data;
		node.link = temp.link;
		temp.link = node;
		size++;
	}
	void reverse() {
		Node first;
		Node rest;
		if (head.link == null) {
			return;
		}
		first = head;
		rest = first.link;
		if (rest == null) {
			return;
		}
		head = rest.link;
		reverse();
		first.link.link = first;
		first.link = null;
		head = rest;
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