/**
 * Queue class.
 * @param      <Item>  The item
 */
public class Queue<Item> implements Iterable<Item> {
    /**
     * first of type Node.
     */
    private Node<Item> first;
    /**
     * second of type Node.
     */
    private Node<Item> last;
    /**
     * size.
     */
    private int n;
    /**
     * Class for node.
     * @param      <Item>  The item
     */
    private static class Node<Item> {
        /**
         * item of type Item.
         */
        private Item item;
        /**
         * next of type Node.
         */
        private Node<Item> next;
    }
    /**
     * Initializes an empty queue.
     */
    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }
    /**
     * Returns true if this queue is empty.
     * @return {@code true} if
     * this queue is empty; {@code false} otherwise
     * Time complexity for this method is O(1).
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * Returns the number of items in this queue.
     * @return the number of items in this queue
     * Time complexity for this method is O(1).
     */
    public int size() {
        return n;
    }
    /**
     * Adds the item to this queue.
     * @param  item the item to add
     * Time complexity for this method is O(1).
     */
    public void enqueue(final Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        n++;
    }
}
