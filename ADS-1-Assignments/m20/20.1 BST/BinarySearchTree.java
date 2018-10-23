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
        /**
         * size.
         */
        private int size;
        /**
         * Constructs the object.
         * @param      k     key.
         * @param      v     value.
         * @param      s     size.
         */
        Node(final Key k, final Value v, final int s) {
            key = k;
            value = v;
            size = s;
        }
    }
    /**
     * Determines if empty.
     * @return     True if empty, False otherwise.
     * Time complexity for this method is O(1).
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * size method that returns the size.
     * @return     size of type int.
     * Time complexity for this method is O(1).
     */
    public int size() {
        return size(root);
    }
    /**
     * size method that returns the size.
     * @param      x     Node.
     * @return     size of type int.
     * Time complexity for this method is O(1).
     */
    private int size(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
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
            return new Node(key, value, 1);
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
     * min method that returns the minimum node.
     * @return     Key of type Book.
     * Time complexity for this method is O(log N).
     */
    public Key min() {
        return min(root).key;
    }
    /**
     * min method that returns the minimum node.
     * @param      x     Node.
     * @return     Node.
     * Time complexity for this method is O(log N).
     */
    private Node min(final Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }
    /**
     * max method that returns the maximum node.
     * @return     Key of type Book.
     * Time complexity for this method is O(log N).
     */
    public Key max() {
        return max(root).key;
    }
    /**
     * min method that returns the minimum node.
     * @param      x     Node.
     * @return     Node.
     * Time complexity for this method is O(log N).
     */
    private Node max(final Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }
    /**
     * floor method that returns the node less
     * than given node.
     * @param      key   The key
     * @return     Key of type Book.
     * Time complexity for this method is O(log N).
     */
    public Key floor(final Key key) {
    	if (isEmpty()) {
    		return null;
    	}
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * floor method that returns the node less
     * than given node.
     * @param      x     Node.
     * @param      key   The key
     * @return     Node.
     * Time complexity for this method is O(log N).
     */
    private Node floor(final Node x, final Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }
    /**
     * ceiling method that returns the node greater
     * than given node.
     * @param      key   The key
     * @return     Key of type Book.
     * Time complexity for this method is O(log N).
     */
    public Key ceiling(final Key key) {
    	if (isEmpty()) {
    		return null;
    	}
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * ceiling method that returns the node greater
     * than given node.
     * @param      x     Node.
     * @param      key   The key
     * @return     Node.
     * Time complexity for this method is O(log N).
     */
    private Node ceiling(final Node x, final Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return ceiling(x.right, key);
    }
    /**
     * select method that returns the node at particular index.
     * @param      k     index.
     * @return     Key of type Book.
     * Time complexity for this method is O(log N).
     */
    public Key select(final int k) {
        Node x = select(root, k);
        return x.key;
    }
    /**
     * select method that returns the node at particular index.
     * @param      x     Node.
     * @param      k     index.
     * @return     Node.
     * Time complexity for this method is O(log N).
     */
    private Node select(final Node x, final int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k) {
            return select(x.left, k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }
    public int rank(Key key, Node x) {
    	return rank1(key, root);
    }
    private int rank1(Key key, Node x) {
    	if (x == null) {
    		return 0;
    	}
    	int cmp = key.compareTo(x.key);
    	if (cmp < 0) {
    		return rank1(key, x.left);
    	} else if (cmp > 0) {
    		return 1 + size(x.left) + rank1(key, x.right);
    	} else {
    		return size(x.left);
    	}
    }
    public void delete(Key key) {
    	root = delete(root, key);
    }
    private Node delete(Node x, Key key) {
    	if (x == null) {
    		return null;
    	}
    	int cmp = key.compareTo(x.key);
    	if (cmp < 0) {
    		x.left = delete(x.left, key);
    	} else if (cmp > 0) {
    		x.right = delete(x.right, key);
    	} else {
    		if (x.right == null) {
    			return x.left;
    		}
    		if (x.left == null) {
    			return x.right;
    		}
    		Node t = x;
    		x = min(t.right);
    		x.right = deleteMin(t.right);
    		x.left = t.left;
    	}
    	x.size = size(x.left) + size(x.right) + 1;
    	return x;
    }
    public void deleteMin() {
    	root = deleteMin(root);
    }
    private Node deleteMin(Node x) {
    	if (x.left == null) {
    		return x.right;
    	}
    	x.left = deleteMin(x.left);
    	x.size = size(x.left) + size(x.right) + 1;
    	return x;
    }
    public void deleteMax() {
    	root = deleteMax(root);
    }
    private Node deleteMax(Node x) {
    	if (x.right == null) {
    		return x.left;
    	}
    	x.right = deleteMax(x.right);
    	x.size = size(x.left) + size(x.right) + 1;
    	return x;
    }
}
