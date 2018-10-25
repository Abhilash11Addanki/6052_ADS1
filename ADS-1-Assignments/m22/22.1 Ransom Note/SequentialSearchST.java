public class SequentialSearchST<Key, Value> {
    private int n;           // number of key-value pairs
    private Node first;      // the linked list of key-value pairs

    // a helper linked list data type
    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(final Key key, final Value val, final Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }
    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
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
