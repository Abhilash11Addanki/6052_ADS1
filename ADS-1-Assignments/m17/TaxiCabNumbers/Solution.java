import java.util.Scanner;
public final class Solution {
    private Solution() {
    }
    public static void main(String[] args) {
        int range = 550;
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int noofways = sc.nextInt();
        int count = 0;
        int temp = -1;
        // initialize priority queue
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 0; i <= range; i++) {
            pq.insert(new CubeSum(i, i));
        }
        // find smallest sum, print it out, and update
        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();
            if (temp == s.sum) {
                count++;
            } else {
                count = 0;
            }
            if (count == noofways - 1) {
                number--;
            }
            if (number == 0) {
                System.out.println(s.sum);
                break;
            }
            temp = s.sum;
            if (s.j < number)
                pq.insert(new CubeSum(s.i, s.j + 1));
        }
    }
}
