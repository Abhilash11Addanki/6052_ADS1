class Stack {
	class Node {
		String data;
		Node link;
	}
	Node head;
	int top = -1;
	int size;
	boolean isEmpty() {
		return top == -1;
	}
	int getsize() {
		return size;
	}
	void push(String data) {
		Node node = new Node();
		++top;
		if (head == null) {
			node.data = data;
			node.link = null;
			head = node;
		} else {
			node.data = data;
			node.link = head;
			head = node;
		}
		size++;
	}
	String pop() {
		top--;
		Node temp = head;
		head = head.link;
		size--;
		return temp.data;
	}
	void display() {
		if (top == -1) {
			System.out.println("Empty");
			return;
		}
		if (head.link == null) {
			System.out.println("[" + head.data + "]");
			return;
		}
		Node temp = head;
		System.out.print("[");
		while (temp.link != null) {
			System.out.print(temp.data + ", ");
			temp = temp.link;
		}
		System.out.println(temp.data + "]");
	}
}