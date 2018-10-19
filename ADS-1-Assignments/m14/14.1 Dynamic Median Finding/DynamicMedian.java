/**
 * Class for dynamic median.
 */
class DynamicMedian {
    /**
     *the object to access of minheap.
     */
    private MinPQ<Double> minObj;
    /**
     *the object to access of maxheap.
     */
    private MaxPQ<Double> maxObj;
    /**
     *the constructor for initializing.
     */
    DynamicMedian() {
        minObj = new MinPQ<Double>();
        maxObj = new MaxPQ<Double>();
    }
    /**
     *the method will insert the element
     *to minheap.
     * @param      item  The item
     * The time complexity for this method is O(1) since
     * we are using insert method.
     */
    public void insertAtMin(final double item) {
        minObj.insert(item);
    }
    /**
     *the method will insert the element
     *to maxheap.
     * @param      item  The item
     * The time complexity for this method is O(1) since
     * we are using insert method.
     */
    public void insertAtMax(final double item) {
        maxObj.insert(item);
    }
    /**
     *this method gets the minimum element.
     * from minheap.
     * @return     The minimum.
     */
    public double getMin() {
        return minObj.min();
    }
    /**
     *this method gets the maximum element.
     * from maxheap.
     * @return     The minimum.
     */
    public double getMax() {
        return maxObj.max();
    }
    /**
     *this method delete the maximum element.
     * from maxheap.
     * @return     The minimum.
     * The time complexity for this method is O(log N) since
     * we are using delMax() method.
     */
    public double delMax() {
        return maxObj.delMax();
    }
    /**
     *this method delete the minimum element.
     * from maxheap.
     * @return     The minimum.
     * The time complexity for this method is O(log N) since
     * we are using delMin() method.
     */
    public double delMin() {
        return minObj.delMin();
    }
    /**
     *gets the size of minheap.
     *
     * @return     The minimum size.
     * Time complexity for this method is O(1).
     */
    public int getMinSize() {
        return minObj.size();
    }
    /**
     * Gets the maximum size of maxheap.
     *
     * @return     The maximum size.
     * Time complexity for this method is O(1).
     */
    public int getMaxSize() {
        return maxObj.size();
    }
}
