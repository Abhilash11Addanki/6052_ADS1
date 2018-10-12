public class CubeSum implements Comparable<CubeSum> {
    int sum;
    int i;
    int j;

    public CubeSum(final int i1, final int j1) {
        sum = i1 * i1 * i1 + j1 * j1 * j1;
        i = i1;
        j = j1;
    }

    public int compareTo(final CubeSum that) {
        if (sum < that.sum) return -1;
        if (sum > that.sum) return +1;
        return 0;
    }

    public String toString() {
        return sum + " = " + i + "^3" + " + " + j + "^3";
    }
}
