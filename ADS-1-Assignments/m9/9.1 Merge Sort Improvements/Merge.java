class Merge {
    /**
     * cutoff to insertion sort.
     */
    private final int x = 7;
    /**
     * Constructs the object.
     */
    Merge() {
    }
    /**
     * Merge Method to merge the arrays.
     * Time complexity of this method is O(N).
     * @param      array  array
     * @param      aux    auxiliary
     * @param      lo     lower value
     * @param      mid    middle value
     * @param      hi     higher value
     */
    public void merge(final Comparable[] arr, final Comparable[] aux,
        final int lo, final int mid, final int hi) {
        assert isSorted(arr, lo, mid);
        assert isSorted(arr, mid + 1, hi);
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                aux[k] = arr[j++];
            } else if (j > hi) {
                aux[k] = arr[i++];
            } else if (less(arr[j], arr[i])) {
                aux[k] = arr[j++];
            } else {
                aux[k] = arr[i++];
            }
        }
        assert isSorted(aux, lo, hi);
    }
    /**
     * sort method.
     * Time complexity of sorting is O(log(N)).
     * @param      array  The array
     * @param      aux    The auxiliary array
     * @param      lo     The lower value
     * @param      hi     The higher value
     */
    public void sort(final Comparable[] arr, final Comparable[] aux,
        final int lo, final int hi) {
        if (hi <= lo + x) {
            insertionSort(aux, lo, hi);
            System.out.println("Insertion sort method invoked..");
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(aux, arr, lo, mid);
        sort(aux, arr, mid + 1, hi);
        if (!less(arr[mid + 1], arr[mid])) {
            for (int i = lo; i <= hi; i++) {
                aux[i] = arr[i];
            }
            System.out.println(
                "Array is already sorted. So, skipped the call to merge...");
            return;
        }
        merge(arr, aux, lo, mid, hi);
    }
    /**
     * Rearranges the array in ascending order, using the natural order.
     * Time complexity of this method is O(N).
     * @param      a     {Comparable array}.
     */
    public void sort(final Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
        assert isSorted(a);
    }
    /**
     * Insertion sort method.
     * Time complexity of insertion sort is O(N^2/2).
     * @param      a     {Comparable array}.
     * @param      lo    The lower value
     * @param      hi    The higher value
     */
    public void insertionSort(final Comparable[] a,
        final int lo, final int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
    /**
     * Method to exchange two elements in the array.
     * Time complexity of this method is O(N).
     * @param      a     {Array of object}
     * @param      i     {Integer i}
     * @param      j     {Integer j}
     */
    public void exch(final Comparable[] a,
        final int i, final int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    /**
     * Method to check which one is smaller of the two.
     * Time complextiy of this method is O(1).
     * @param      a     {Comparable}.
     * @param      b     {Comparable}.
     *
     * @return     {Boolean value}.
     */
    public boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
    /**
     * Method to determine if the array is sorted (or) not.
     * Time complexity of this method is O(1).
     * @param      a     {Comparable array}
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }
    /**
     * Method to determine if the array is sorted (or) not.
     * Time complexity of this method is O(N).
     * @param      a     {Comparable array}
     * @param      lo    The lower
     * @param      hi    The higher
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] a,
        final int lo, final int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
    /**
     * {Method to print the values of the Comparable array}.
     * Time complexity of this method is O(N).
     * @param      a     {Name of object array}
     *
     * @return     {String}
     */
    public String show(final Comparable[] a) {
        String str = "[";
        int i;
        for (i = 0; i < a.length - 1; i++) {
            str += a[i] + ", ";
        }
        str += a[i] + "]";
        return str;
    }
}