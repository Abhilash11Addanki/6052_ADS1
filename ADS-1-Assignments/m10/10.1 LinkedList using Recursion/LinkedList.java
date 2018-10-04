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
		if (pos == 0) {
			insertAtStart(data);
			return;
		}
		pos--;
		Node temp = head;
		while (pos != 0) {
			temp = temp.link;
			pos--;
		}
		node.data = data;
		node.link = temp.link;
		temp.link = node;
		size++;
	}
	void display() {
		if (size == 0) {
			System.out.println("Empty");
			return;
		}
		if (head.link == null) {
			System.out.println(head.data);
			return;
		}
		Node temp = head;
		while (temp.link != null) {
			System.out.print(temp.data + "->");
			temp = temp.link;
		}
		System.out.println(temp.data);
	}
}