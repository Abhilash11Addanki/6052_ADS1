class Stock implements Comparable<Stock> {

    /**
     * name of the stock.
     */
    private String name;

    /**
     * getter for name.
     *
     * @return     name of stock.
     *
     * Time complexity : O(1)
     * constant time.
     */
    String name() {
        return this.name;
    }

    /**
     * percentage of stock rate.
     */
    private Double percentage;

    /**
     * getter for percentage.
     *
     * @return     percentage of stock.
     *
     * Time complexity : O(1)
     * constant time.
     */
    Double percentage() {
        return this.percentage;
    }



    /**
     * Constructs the object.
     *
     * @param      namee    The namee
     * @param      percent  The percent
     */
    Stock(final String namee, final Double percent) {
        this.name = namee;
        this.percentage = percent;
    }

    /**
     * compares the object with other.
     *
     * @param      other  The other object
     *
     * @return     comparision int flag
     *
     * Time complexity : O(1)
     * constant time.
     */
    public int compareTo(final Stock other) {
        int temp = this.percentage.compareTo(other.percentage);
        if (temp != 0) {
            return temp;
        }

        return this.name.compareTo(other.name);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     *
     * Time complexity : O(1)
     * constant time.
     */
    public String toString() {
        return this.name + " " + this.percentage;
    }
}
