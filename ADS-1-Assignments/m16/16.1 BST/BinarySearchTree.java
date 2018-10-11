class BinarySearchTree<Key extends Dummy, Value> {
	private Node root;
	private class Node {
		private Key key;
		private Value value;
		private Node left, right;
		Node(final Key k, final Value v) {
			key = k;
			value = v;
		}
	}
	BinarySearchTree() {
	}
	Value get(Key key) {
		Node n = root;
		if (key == null) {
			return null;
		}
		if (n == null) {
			return null;
		}
		int cmp = key.getName().compareTo(n.key.getName());
		if (cmp < 0) {
			n = n.left;
		} else if (cmp > 0) {
			n = n.right;
		} else {
			return n.value;
		}
		return null;
	}
	void put(Key key, Value val) {
		root = put(root, key, val);
	}
	private Node put(Node n, Key key, Value value) {
		if (n == null) {
			return new Node(key, value);
		}
		int cmp = key.getName().compareTo(n.key.getName());
		if (cmp < 0) {
			n.left = put(n.left, key, value);
		} else if (cmp > 0) {
			n.right = put(n.right, key, value);
		} else {
			n.value = value;
		}
		return n;
	}
}
