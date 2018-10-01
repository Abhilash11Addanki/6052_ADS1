class Stack {
	class Node {
		String data;
		Node link;
	}
	Node head;
	int top = -1;
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
	}
	void pop() {
		top--;
		System.out.println(head.data);
		head = head.link;
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