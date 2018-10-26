import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
/**
 * Class for linear probing hash st.
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
public class LinearProbingHashST<Key, Value> {
    /**
     * initial capacity of type int.
     */
    private static final int INIT_CAPACITY = 4;
    /**
     * number of key-value pairs in the symbol table.
     */
    private int n;
    /**
     * size of linear probing table.
     */
    private int m;
    /**
     * the keys.
     */
    private Key[] keys;
    /**
     * the values.
     */
    private Value[] vals;
    /**
     * Initializes an empty symbol table.
     */
    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }
    /**
     * Initializes an empty symbol table with the specified initial capacity.
     * @param capacity the initial capacity
     */
    public LinearProbingHashST(final int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
    }
    public boolean contains(final Key key) {
        return get(key) != null;
    }
    /**
     * keys method that adds the keys into the queue.
     * @return     queue of type Iterable.
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<Key>();
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                queue.add(keys[i]);
            }
        }
        return queue;
    }
    /**
     * hash function for keys - returns value between 0 and M-1.
     * @param      key   The key
     * @return     hash value of type int.
     */
    private int hash(final Key key) {
        return 11 * (key.hashCode() & 0x7fffffff) % m;
    }
    /**
     * Inserts the key value pair to the symbol table.
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }
    /**
     * Returns the value associated with the specified key.
     * @param      key   The key
     * @return     value of the specified key of type Value.
     */
    public Value get(final Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }
    /**
     * deletes the specified key from the symbol table.
     * @param      key   The key
     */
    public void delete(final Key key) {
        if (!contains(key)) {
            return;
        }
        // find position i of key
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }
        // delete key and associated value
        keys[i] = null;
        vals[i] = null;
        // rehash all keys in same cluster
        i = (i + 1) % m;
        while (keys[i] != null) {
            // delete keys[i] an vals[i] and reinsert
            Key   keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }
        n--;
    }
}
