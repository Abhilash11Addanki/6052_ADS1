class Steque<T> {
class Node {
		T data;
		Node link;
	}
	Node head;
	int size;
	/**
	 * This method pushes the element into the linked list.
	 * The time complexity for this method is O(1) because the element 
	    is pushed after the first node and it is made as head.
	 * @param      data  The data
	 */
	void push(T data) {
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
	/**
	 * This method pops the first element from the linked list.
	 * The time complexity for this method is O(1) because the first element
	    is popped from the linked list.
	 */
	void pop() {
		if (size == 0) {
			return;
		}
		Node node = new Node();
		Node temp = head;
		temp = temp.link;
		head.link = null;
		head = temp;
		size--;
	}
	/**
	 * This method inserts the element at the end of the linked list.
	 * The time complexity for this method is O(N) because to insert
	   the element at the end the function should traverse till end of the list.
	 * @param      data  The data
	 */
	void insertAtEnd(T data) {
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
	/**
	 * This method displays the elements in the linked list.
	 * The time complexity for this method is O(N) because to display the 
	   elements the function should traverse till end of the list.
	 */
	void display() {
		if (size == 0) {
			System.out.println("Steque is empty.");
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