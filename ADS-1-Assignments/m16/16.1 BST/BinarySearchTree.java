class BinarySearchTree<Key extends Comparable<Key>, Value> {
	private Node root;
	public class Node {
		private Key key;
		private Value value;
		private Node left, right;
		Node(final Key k, final Value v) {
			key = k;
			value = v;
		}
	}
	Value get(Key k) {
		Node n = root;
		if (k == null) {
			return null;
		}
		if (n == null) {
			return null;
		}
		int cmp = k.compareTo(n.key);
		if (cmp < 0) {
			n = n.left;
		} else if (cmp > 0) {
			n = n.right;
		} else {
			return n.value;
		}
		return null;
	}
	void put(Key k, Value val) {
		root = put(root, k, val);
	}
	private Node put(Node n, Key k, Value value) {
		if (n == null) {
			return new Node(k, value);
		}
		int cmp = k.compareTo(n.key);
		if (cmp < 0) {
			n.left = put(n.left, k, value);
		} else if (cmp > 0) {
			n.right = put(n.right, k, value);
		} else {
			n.value = value;
		}
		return n;
	}
}
