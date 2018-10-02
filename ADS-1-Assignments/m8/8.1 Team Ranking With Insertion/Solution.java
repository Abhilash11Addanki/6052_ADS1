import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
class Team implements Comparable<Team> {
	String teamname;
	int wins;
	int losses;
	int draws;
	Team (String t, int w, int l, int d) {
		teamname = t;
		wins = w;
		losses = l;
		draws = d;
	}
	public int compareTo(Team t) {
		if (wins > t.wins) {
			return 1;
		}
		if (wins < t.wins) {
			return -1;
		}
		if (losses < t.losses) {
			return 1;
		}
		if (losses > t.losses) {
			return -1;
		}
		if (draws > t.draws) {
			return 1;
		}
		if (draws < t.draws) {
			return -1;
		}
		return 0;
	}
	public String toString() {
		return teamname;
	}
}
class Teams {
	/**
	 * { var_description }.
	 */
	Team[] arr;
	/**
	 * { var_description }.
	 */
	int size;
	/**
	 * Constructs the object.
	 */
	Teams() {
		arr = new Team[10];
		size = 0;
	}
	/**
	 * { function_description }.
	 * @param      item  The item
	 */
	public void add(final Team item) {
		//Inserts the specified element at the end of the list.
		//You can modify the code in this method.
		arr[size++] = item;
	}
	public String toString() {
		String s = "";
		for (int i = 0; i < size; i++) {
			s += arr[i].teamname + ",";
		}
		return s.substring(0, s.length() - 1);
	}
}
class SelectionSort {
	Teams t = new Teams();
	Teams sort() {
		for (int i = 0; i < t.size - 1; i++) {
			int index = i;
			for (int j = i + 1; j < t.size; j++) {
				if (less(t.arr, j, index)) {
					index = j;
				}
			}
			exch(t.arr, i , index);
		}
		return t;
	}
	void exch(Team[] arr, int i, int j) {
		Team te = t.arr[j];
		t.arr[j] = t.arr[i];
		t.arr[i] = te;
	}
	boolean less(Team[] arr, int i, int j) {
		return arr[i].compareTo(arr[j]) > 0;
	}
}
public final class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SelectionSort s = new SelectionSort();
		Teams t = new Teams();
		while (sc.hasNext()) {
			String[] tokens = sc.nextLine().split(",");
			t.add(new Team(tokens[0], Integer.parseInt(tokens[1]),
			               Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
		}
		t = s.sort();
		System.out.println(t);
	}
}