class LinearProbingHashST<Key, Value> {
    private static final int capacity = 4;
    private int n;
    private int m;
    private Key[] keys;
    private Value[] values;
    public LinearProbingHashST() {
        this(capacity);
    }
    public LinearProbingHashST(int cap) {
        m = cap;
        n = 0;
        keys = (Key[]) new Object[m];
        values = (Value[]) new Object[m];
    }
    public void put(Key key, Value val) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                values[i] = val;
                return;
            }
        }
        keys[i] = key;
        values[i] = val;
        n++;
    }
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }
    public void display() {
        System.out.print("{");
        for (int i = 0; i < m; i++) {
            if (i == m - 1) {
                System.out.print(keys[i] + ":" + values[i]);
            }
            System.out.print(keys[i] + ":" + values[i] + ", ");
        }
    }
    public void delete(Key key) {
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }
        keys[i] = null;
        values[i] = null;
        i = (i + 1) % m;
        while (keys[i] != null) {
            Key   keyToRehash = keys[i];
            Value valToRehash = values[i];
            keys[i] = null;
            values[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }
        n--;
    }
}
