public class BinarySearchST <Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] values;
	private int size = 0;
	BinarySearchST(int size) {
		keys = (Key[]) new Comparable[size];
		values = (Value[]) new Object[size];
	}
	private void resize(int size) {
		Key[] k = (Key[]) new Comparable[size];
		Value[] v = (Value[]) new Object[size];
		for (int i = 0; i < size; i++) {
			k[i] = keys[i];
			v[i] = values[i];
		}
		values = v;
		keys = k;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public void delete(Key key) {
		if (key == null) {
			return;
		}
		if (isEmpty()) {
			return;
		}
		int i = rank(key);
		if (i == size || keys[i].compareTo(key) != 0) {
			return;
		}
		for (int j = i; j < size - 1; j++)  {
			keys[j] = keys[j + 1];
			values[j] = values[j + 1];
		}
		size--;
		keys[size] = null;
		values[size] = null;

		if (size > 0 && size == keys.length / 4) resize(keys.length / 2);
	}
	public void put(Key key, Value value) {
		if (key == null) {
			return;
		}
		if (value == null) {
			delete(key);
			return;
		}
		int i = rank(key);
		if (i < size && keys[i].compareTo(key) == 0) {
			values[i] = value;
			return;
		}
		if (size == keys.length) {
			resize(2 * keys.length);
		}
		for (int j = size; j > i; j--) {
			keys[j] = keys[j - 1];
			values[j] = values[j - 1];
		}
		keys[i] = key;
		values[i] = value;
		size++;
	}
	public boolean contains(Key key) {
		if (key == null) {
			return false;
		}
		return get(key) != null;
	}
	public Value get(Key key) {
		if (key == null) {
			return null;
		}
		if (isEmpty()) {
			return null;
		}
		int i = rank(key);
		if (i < size && keys[i].compareTo(key) == 0) {
			return values[i];
		}
		return null;
	}
	public Key max() {
		if (isEmpty()) {
			return null;
		}
		return keys[size - 1];
	}
	public Key min() {
		if (isEmpty()) {
			return null;
		}
		return keys[0];
	}
	public Key floor(Key key) {
		if (key == null) {
			return null;
		}
		int i = rank(key);
		if (i < size && key.compareTo(keys[i]) == 0) {
			return keys[i];
		}
		if (i == 0) {
			return null;
		}
		return keys[i - 1];
	}
	public int rank(Key key) {
		if (key == null) {
			return 0;
		}
		int lo = 0, hi = size - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0) {
				hi = mid - 1;
			} else if (cmp > 0) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return lo;
	}
	public void deleteMin() {
		if (isEmpty()) {
			return;
		}
		delete(min());
	}
	public Iterable<Key> keys() {
		return keys(min(), max());
	}
	public Iterable<Key> keys(Key lo, Key hi) {
		if (lo == null || hi == null) {
			return null;
		}
		Queue<Key> queue = new Queue<Key>();
		if (lo.compareTo(hi) > 0) {
			return queue;
		}
		for (int i = rank(lo); i < rank(hi); i++) {
			queue.enqueue(keys[i]);
		}
		if (contains(hi)) {
			queue.enqueue(keys[rank(hi)]);
		}
		return queue;
	}
}
