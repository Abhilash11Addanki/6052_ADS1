import java.util.Scanner;
class Percolation {
	private boolean[][] id;
	private int top = 0;
	private int bottom;
	private int size;
	private WeightedQuickUnionUF qf;
	public Percolation(int n) {
		size = n;
		bottom = size * size + 1;
		qf = new WeightedQuickUnionUF(size * size + 2);
		id = new boolean[size][size];
	}

	public void open(int row, int col) {
		id[row - 1][col - 1] = true;
		if (row == 1) {
			qf.union(getQFIndex(row, col), top);
		}
		if (row == size) {
			qf.union(getQFIndex(row, col), bottom);
		}
		if (col > 1 && isOpen(row, col - 1)) {
			qf.union(getQFIndex(row, col), getQFIndex(row, col - 1));
		}
		if (col < size && isOpen(row, col + 1)) {
			qf.union(getQFIndex(row, col), getQFIndex(row, col + 1));
		}
		if (row > 1 && isOpen(row - 1, col)) {
			qf.union(getQFIndex(row, col), getQFIndex(row - 1, col));
		}
		if (row < size && isOpen(row + 1, col)) {
			qf.union(getQFIndex(row, col), getQFIndex(row + 1, col));
		}
	}
	public boolean isOpen(int row, int col) {
		return id[row - 1][col - 1];
	}
	public boolean isFull(int row, int col) {
		if (0 < row && row <= size && 0 < col && col <= size) {
			return qf.connected(top, getQFIndex(row, col));
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	public boolean percolates() {
		return qf.connected(top, bottom);
	}
	public int getQFIndex(int row, int col) {
		return size * (row - 1) + col;
	}
}
class WeightedQuickUnionUF {
	private int[] parent;
	private int[] size;
	private int count;
	public WeightedQuickUnionUF(int n) {
		count = n;
		parent = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}
	public int count() {
		return count;
	}
	public int find(int p) {
		validate(p);
		while (p != parent[p])
			p = parent[p];
		return p;
	}
	private void validate(int p) {
		int n = parent.length;
		if (p < 0 || p >= n) {
			throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
		}
	}
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ) return;

		if (size[rootP] < size[rootQ]) {
			parent[rootP] = rootQ;
			size[rootQ] += size[rootP];
		} else {
			parent[rootQ] = rootP;
			size[rootP] += size[rootQ];
		}
		count--;
	}
}
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noofnodes = Integer.parseInt(sc.nextLine());
		Percolation p = new Percolation(noofnodes);
		String[] tokens = new String[2];
		while (sc.hasNext()) {
			String line = sc.nextLine();
			tokens = line.split(" ");
			p.open(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
		}
		System.out.println(p.percolates());
	}
}