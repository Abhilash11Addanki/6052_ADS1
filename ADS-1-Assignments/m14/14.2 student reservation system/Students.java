/**
 * Class for students.
 */
class Students {
    /**
     * arr array of type StudentInfo.
     */
    StudentInfo[] arr;
    /**
     * size of array.
     */
    int size;
    /**
     * Constructs the object.
     * @param      s     size of array.
     */
    Students(final int s) {
        arr = new StudentInfo[s];
        size = 0;
    }
    /**
     * add method.
     * @param      item  The item
     */
    public void add(final StudentInfo item) {
        arr[size++] = item;
    }
    /**
     * show method.
     * @param      i     index.
     * @return     array element of type StudentInfo.
     */
    StudentInfo show(final int i) {
        return arr[i];
    }
    /**
     * exch method of which swaps the elements.
     * @param      arr   The arr
     * @param      i     index.
     * @param      j     index.
     */
    void exch(final StudentInfo[] arr, final int i,
        final int j) {
        StudentInfo s = arr[j];
        arr[j] = arr[i];
        arr[i] = s;
    }
    /**
     * sort method.
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
     * @param      arr   The arr
     * @param      i     index.
     * @param      j     index.
     * @return     true or false.
     */
    boolean less(final StudentInfo[] arr, final int i,
        final int j) {
        return  arr[i].compareTo(arr[j]) < 0;
    }
}
