/**
 * Class for students.
 */
class Students {
    /**
     * arr array of type StudentInfo.
     */
    private StudentInfo[] arr;
    /**
     * size of array.
     */
    private int size;
    /**
     * Constructs the object.
     * @param      s     size of array.
     */
    Students(final int s) {
        arr = new StudentInfo[s];
        size = 0;
    }
    /**
     * gets the element of array at specific.
     * index.
     * @param      i     index.
     * @return     element of type StudentInfo.
     * Time complexity for this method is O(1).
     */
    StudentInfo getarr(final int i) {
        return arr[i];
    }
    /**
     * add method.
     * @param      item  The item
     * Time complexity for this method is O(1).
     */
    public void add(final StudentInfo item) {
        arr[size++] = item;
    }
    /**
     * show method.
     * @param      i     index.
     * @return     array element of type StudentInfo.
     * Time complexity for this method is O(1).
     */
    StudentInfo show(final int i) {
        return arr[i];
    }
    /**
     * exch method to swap the elements.
     * @param      a     array of type StudentInfo.
     * @param      i     index.
     * @param      j     index.
     */
    void exch(final StudentInfo[] a, final int i,
        final int j) {
        StudentInfo s = a[j];
        a[j] = a[i];
        a[i] = s;
    }
    /**
     * sort method.
     * The worst case time complexity
       for this method is O(N^2).
     */
    void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (less(arr, j - 1, j)) {
                    exch(arr, j - 1, j);
                }
            }
        }
    }
    /**
     * less method which compares the elements of.
     * array.
     * @param      a   The arr
     * @param      i     index.
     * @param      j     index.
     * @return     true or false.
     */
    boolean less(final StudentInfo[] a, final int i,
        final int j) {
        return  a[i].compareTo(a[j]) < 0;
    }
}
