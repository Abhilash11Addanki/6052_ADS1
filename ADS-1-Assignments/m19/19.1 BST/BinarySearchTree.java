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
		/**.
		 * Constructs the object.
		 *
		 * @param      k  The key 1
		 * @param      v   The value
		 */
		Node(final Key k, final Value v, final int s) {
			key = k;
			value = v;
			size = s;
		}

	}
	public boolean isEmpty() {
		return size() == 0;
	}
	public int size() {
		return size(root);
	}
	private int size(Node x) {
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
	public Key min() {
		return min(root).key;
	}
	private Node min(Node x) {
		if (x.left == null) {
			return x;
		} else {
			return min(x.left);
		}
	}
	public Key max() {
		return max(root).key;
	}
	private Node max(Node x) {
		if (x.right == null) {
			return x;
		} else {
			return max(x.right);
		}
	}
	public Key floor(Key key) {
		Node x = floor(root, key);
		if (x == null) {
			return null;
		} else {
			return x.key;
		}
	}
	private Node floor(Node x, Key key) {
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
	public Key ceiling(Key key) {
		Node x = ceiling(root, key);
		if (x == null) {
			return null;
		} else {
			return x.key;
		}
	}
	private Node ceiling(Node x, Key key) {
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
	public Key select(int k) {
		Node x = select(root, k);
		return x.key;
	}
	private Node select(Node x, int k) {
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
	public int rank(Key key) {
		return rank(key, root);
	}
	private int rank(Key key, Node x) {
		if (x == null) {
			return 0;
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			return rank(key, x.left);
		} else if (cmp > 0) {
			return 1 + size(x.left) + rank(key, x.right);
		}
		return size(x.left);
	}
	public Iterable<Key> keys() {
		if (isEmpty()) return new Queue<Key>();
		return keys(min(), max());
	}
	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue, lo, hi);
		return queue;
	}
	private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
		if (x == null) return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if (cmplo < 0) keys(x.left, queue, lo, hi);
		if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
		if (cmphi > 0) keys(x.right, queue, lo, hi);
	}
}
