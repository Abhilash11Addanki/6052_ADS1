import java.util.Scanner;
import java.util.ArrayList;
/**
 * Solution class.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method that drives the program.
     * @param      args  The command line arguments
     * Time complexity for this method is O(N)
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfStocks = Integer.parseInt(sc.nextLine());
        final int hours = 6;
        final int five = 5;
        BinarySearchST<String, Integer> maxST =
            new BinarySearchST<String, Integer>(noOfStocks);
        BinarySearchST<String, Integer> minST =
            new BinarySearchST<String, Integer>(noOfStocks);
        for (int i = 0; i < hours; i++) {
            MinPQ<Stock> minpq = new MinPQ<Stock>(noOfStocks);
            MaxPQ<Stock> maxpq = new MaxPQ<Stock>(noOfStocks);
            for (int j = 0; j < noOfStocks; j++) {
                String[] input = sc.nextLine().split(",");
                Stock stock = new Stock(input[0],
                                        Double.parseDouble(input[1]));
                minpq.insert(stock);
                maxpq.insert(stock);
            }
            for (int k = 0; k < five; k++) {
                Stock temp = maxpq.delMax();
                Integer num = maxST.get(temp.name());
                if (num != null) {
                    maxST.put(temp.name(), num + 1);
                } else {
                    maxST.put(temp.name(), 1);
                }
                System.out.println(temp);
            }
            System.out.println();

            for (int k = 0; k < five; k++) {
                Stock temp = minpq.delMin();
                Integer num = minST.get(temp.name());
                if (num != null) {
                    minST.put(temp.name(), num + 1);
                } else {
                    minST.put(temp.name(), 1);
                }
                System.out.println(temp);
            }
            System.out.println();
        }

        int noOfQueries = sc.nextInt();
        if (noOfQueries == 0) {
            return;
        }

        sc.nextLine();

        for (int i = 0; i < noOfQueries; i++) {
            String[] tokens = sc.nextLine().split(",");
            if (tokens[0].equals("get")) {
                if (tokens[1].equals("minST")) {
                    Integer freq = minST.get(tokens[2]);
                    if (freq != null) {
                        System.out.println(freq);
                    } else {
                        System.out.println(0);
                    }
                } else {
                    Integer freq = maxST.get(tokens[2]);
                    if (freq != null) {
                        System.out.println(freq);
                    } else {
                        System.out.println(0);
                    }
                }
            } else if (tokens[0].equals("intersection")) {
                ArrayList<String> keys = minST.keys();
                for (String key : keys) {
                    if (maxST.contains(key)) {
                        System.out.println(key);
                    }
                }
            }

        }

    }

}
