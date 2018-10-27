import java.util.Queue;
import java.util.LinkedList;
/**
 * Class for binary search tree.
 * @param      <Key>     The key
 * @param      <Value>  The values
 */
class BinarySearchTree<Key extends Comparable<Key>, Value> {
    /**.
     * starting element in the BST.
     */
    private Node root;
    /**.
     * Class for node.
     */
    class Node {
        /**.
         * Object of Book class with book details.
         */
        private Key key;
        /**.
         * value of the book in Book class
         */
        private Value value;
        /**.
         * Left and Right node of the BST
         */
        private Node left, right;
        /**.
         * Constructs the object.
         *
         * @param      k  The key 1
         * @param      v   The value
         */
        Node(final Key k, final Value v) {
            key = k;
            value = v;
        }

    }
    /**.
     * This method is to add a key and value to BST.
     * Time Complexity is O(N).
     * because it calls another put method to add elements.
     *
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Key key, final Value value) {
        if (key == null) {
            return;
        }
        root = put(root, key, value);
    }
    /**.
     * This method is to add element to BST
     * Time Complexity is O(N) for worst case.
     * element is added until it reaches to the
     * position it should added at.
     *
     * @param      node   The node
     * @param      key    The key
     * @param      value  The value
     *
     * @return     returns node
     */
    public Node put(final Node node, final Key key,
                    final Value value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }
    /**.
     * This method is to return the value of that key
     * Time Complexity is O(N)
     *
     * @param      key   The key
     *
     * @return     returns the value.
     */
    public Value get(final Key key) {
        return get(root, key);
    }
    /**.
     * This method is to return the value of that key
     * Time Complexity is O(N)
     *
     * @param      node  the node where the book details and
     *                   values.
     * @param      key   The key
     *
     * @return     returns the value of that key.
     */
    private Value get(final Node node, final Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }
    /**
     * returns the keys.
     * @return     keys of type Iterable.
     */
    public Iterable<Key> keys() {
        return keys(min(), max());
    }
    /**
     * returns the keys.
     * @param      lo    The lower
     * @param      hi    The higher
     * @return     keys of type Iterable.
     */
    public Iterable<Key> keys(final Key lo, final Key hi) {
        Queue<Key> queue = new LinkedList<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }
    /**
     * keys method.
     * @param      x      Node.
     * @param      queue  The queue
     * @param      lo     The lower
     * @param      hi     The higher
     */
    private void keys(final Node x, final Queue<Key> queue,
        final Key lo, final Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.add(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }
    /**
    * Returns the smallest key in the symbol table.
    * @return the smallest key in the symbol table
    */
    public Key min() {
        return min(root).key;
    }
    /**
     * min method that returns smallest key.
     * @param      x     Node.
     * @return     Node.
     */
    private Node min(final Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }
    /**
     * Returns the largest key in the symbol table.
     * @return the largest key in the symbol table
     */
    public Key max() {
        return max(root).key;
    }
    /**
     * max method that returns largest key.
     * @param      x     Node.
     * @return     Node.
     */
    private Node max(final Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }
}
