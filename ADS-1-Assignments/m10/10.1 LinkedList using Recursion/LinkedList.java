/**
 * Class for node.
 */
class Node {
    /**
     * data of the node.
     */
    int data;
    /**
     * link of the node.
     */
    Node link;
    /**
     * Constructs the object.
     * @param      d     data of the node.
     */
    Node(int d) {
        data = d;
    }
}
/**
 * List of linked list.
 */
public class LinkedList {
    /**
     * head node.
     */
    Node head;
    /**
     * size of the list.
     */
    int size;
    /**
     * insertAt method to insert at specific index.
     * @param      cur        The current
     * @param      newNode    The new node
     * @param      pos        The position
     * @param      curPos     The current position
     *
     * @return     node.
     *
     * @throws     Exception  position exception.
     */
    Node insertAt(final Node cur, final Node newNode,
        final int pos, final int curPos) throws Exception {
        if (pos < 0 || pos > size) {
            throw new Exception("Can't insert at this position.");
        }
        if (cur == null) {
            return newNode;
        } else if (curPos == pos) {
            newNode.link = cur;
            return newNode;
        }
        cur.link = insertAt(cur.link, newNode, pos, curPos + 1);
        return cur;
    }
    /**
     * reverse method to reverse the nodes of linked list.
     * @param      cur   The current
     * @param      prev  The previous
     * @return     head node.
     */
    Node reverse(final Node cur, final Node prev) {
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
    /**
     * display method to display the linked list.
     */
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
