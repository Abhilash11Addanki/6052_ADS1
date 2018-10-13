/**
 * Class for stock.
 */
class Stock implements Comparable<Stock> {
    /**
     * name of the stock.
     */
    private String name;
    /**
     * percentage of stock rate.
     */
    private Double percentage;
    /**
     * gets the name of stock.
     * @return     name of stock.
     */
    String name() {
        return name;
    }
    /**
     * gets the percentage.
     * @return     percentage of stock.
     */
    Double percentage() {
        return percentage;
    }
    /**
     * Constructs the object.
     * @param      n    The namee
     * @param      p  The percent
     */
    Stock(final String n, final Double p) {
        name = n;
        percentage = p;
    }
    /**
     * compareTo method.
     * @param      stock  The other object
     * @return     integer
     */
    public int compareTo(final Stock stock) {
        int cmp = percentage.compareTo(stock.percentage);
        if (cmp != 0) {
            return cmp;
        }
        return name.compareTo(stock.name);
    }
    /**
     * Returns a string representation of the object.
     * @return     String.
     */
    public String toString() {
        return name + " " + percentage;
    }
}
