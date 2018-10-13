import java.util.ArrayList;
/**
 * Class for binary search st.
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchST<Key extends Comparable<Key>, Value> {
    /**
     * keys array of type Key.
     */
    private Key[] keys;
    /**
     * values array of type Value.
     */
    private Value[] values;
    /**
     * size of array.
     */
    private int n;
    /**
     * Constructs the object.
     */
    BinarySearchST() {
    }
    /**
     * Constructs the object.
     * @param      capacity  The capacity
     */
    BinarySearchST(final int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }
    /**
     * size of array.
     * @return     integer.
     */
    public int size() {
        return n;
    }
    /**
     * Determines if empty.
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return n == 0;
    }
    /**
     * resize array.
     * @param      capacity  The capacity
     */
    public void resize(final int capacity) {
        Key[] tkey = (Key[]) new Comparable[capacity];
        Value[] tval = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tkey[i] = keys[i];
            tval[i] = values[i];
        }
        values = tval;
        keys = tkey;
    }
    /**
     * inserts the value at particular key.
     * @param      k     The key.
     * @param      v     The value.
     * Time complexity for this method is log(N).
     */
    public void put(final Key k, final Value v) {
        if (k == null) {
            throw new IllegalArgumentException("Null key");
        }
        if (v == null) {
            delete(k);
            return;
        }
        int i = rank(k);
        if (i < n && keys[i].compareTo(k) == 0) {
            values[i] = v;
            return;
        }
        if (n == keys.length) {
            resize(2 * keys.length);
        }
        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = k;
        values[i] = v;
        n++;
    }
    /**
     * Checks if the key is present or not.
     * @param      k    The key.
     * @return     True or false.
     */
    public boolean contains(final Key k) {
        return get(k) != null;
    }
    /**
     * delete the key.
     * @param      key   The key
     */
    public void delete(final Key key) {
        final int four = 4;
        final int two = 2;
        if (isEmpty()) {
            return;
        }
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        int i = rank(key);
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }
        for (int j = i; j < n - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        n--;
        keys[n] = null;
        values[n] = null;
        if (n > 0 && n == keys.length / four) {
            resize(keys.length / two);
        }
    }

    /**
     * Gives the value of the key.
     * @param      k     The key.
     * @return     The value of the given key.
     * Time complexity for this method is log(N)
     */
    public Value get(final Key k) {
        if (isEmpty()) {
            return null;
        }
        if (k == null) {
            throw new IllegalArgumentException("Key is null");
        }
        int i = rank(k);
        if (i < n && keys[i].compareTo(k) == 0) {
            return values[i];
        } else {
            return null;
        }

    }
    /**
     * Method to find maximum key.
     * @return     the maximum key.
     */
    public Key max() {
        return keys[n - 1];
    }
    /**
     * Method to find the floor for the given key.
     * @param      key   The key
     * @return     the floor of the key
     */
    public Key floor(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to floor() is null");
        }
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            return keys[i];
        }
        if (i == 0) {
            return null;
        } else {
            return keys[i - 1];
        }
    }
    /**
     * Method to find rank of the key.
     *
     * @param      key   The key
     *
     * @return     The rank of the given key
     */
    public int rank(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to rank() is null");
        }
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
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
    /**
     * Minimum key.
     *
     * @return     the minimum key
     */
    public Key min() {
        return keys[0];
    }
    /**
     * Iterate through keys.
     * @return     keys
     */
    public ArrayList<String> keys() {
        return keys(min(), max());
    }
    /**
     * Method to delete the minimum key.
     */
    public void deleteMin() {
        delete(min());
    }
    /**
     * Iterate through keys.
     *
     * @param      lo    The lower
     * @param      hi    The higher
     *
     * @return     keys
     */
    public ArrayList<String> keys(final Key lo, final Key hi) {
        if (lo == null) {
            throw new IllegalArgumentException(
                "first argument to keys() is null");
        }
        if (hi == null) {
            throw new IllegalArgumentException(
                "last argument to keys() is null");
        }
        ArrayList<String> l = new ArrayList<>();
        if (lo.compareTo(hi) > 0) {
            return l;
        }
        for (int i = rank(lo); i < rank(hi); i++) {
            l.add((String) keys[i]);
        }
        if (contains(hi)) {
            l.add((String) keys[rank(hi)]);
        }
        return l;
    }
}
