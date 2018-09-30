class CircularLinkedList {

    private Node head = null;
    private Node tail = null;
    private Node current = null;

    class Node {
        private int data;
        private Node next;
    }
    public boolean isEmpty() {
        return head == null;
    }

    public void add(final int item) {
        if (head == null) {
            head = new Node();
            head.data = item;
            tail = head;
            head.next = tail;
        } else {
            Node newnode = new Node();
            tail.next = newnode;
            newnode.data = item;
            newnode.next = head;
            tail = newnode;
        }
    }

    public int getNext() {
        if (current == null) {
            current = head;
        }
        Node tmp = current;
        current = tmp.next;
        return tmp.data;
    }

    public int remove(int element) {

        if (head.next.equals(head) && head.data == element) {
            int tmp = head.data;
            head = null;
            return tmp;
        }

        if (head.data == element) {
            head = head.next;
            tail.next = head;
            return element;
        }

        if (tail.data == element) {
            Node tempp = head;
            while (!tempp.next.equals(tail)) {
                tempp = tempp.next;
            }
            tempp.next = head;
            tail = tempp;
            return element;
        }

        Node currenttmp = head;
        while (currenttmp.next.data != element) {
            currenttmp = currenttmp.next;
        }
        Node tmp2 = currenttmp.next.next;
        currenttmp.next = tmp2;

        return element;

    }
}
