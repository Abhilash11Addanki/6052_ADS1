/**
 * Class for sequential search st.
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
public class SequentialSearchST<Key, Value> {
    /**
     * number of key-value pairs.
     */
    private int n;
    /**
     * the linked list of key-value pairs.
     */
    private Node first;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * key of type String.
         */
        private Key key;
        /**
         * val of type Integer.
         */
        private Value val;
        /**
         * next of type Node.
         */
        private Node next;
        /**
         * Constructs the object.
         * @param      key   The key
         * @param      val   The value
         * @param      next  The next
         */
        public Node(final Key key, final Value val, final Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }
    /**
     * Checks whether the key is present in the symbol table or not.
     * @param      key   The key
     * @return     true or false.
     */
    public boolean contains(final Key key) {
        return get(key) != null;
    }
    /**
     * gets the value of the particular key in the symbol table.
     * @param      key   The key
     * @return     Value of type Integer.
     */
    public Value get(final Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.val;
        }
        return null;
    }
    /**
     * inserts key value pair into the symbol table.
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }
}
