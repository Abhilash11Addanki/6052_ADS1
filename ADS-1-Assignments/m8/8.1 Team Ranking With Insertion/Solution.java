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
	Team[] teams;
	/**
	 * { var_description }.
	 */
	int size;
	/**
	 * Constructs the object.
	 */
	Teams() {
		teams = new Team[10];
	}
	/**
	 * { function_description }.
	 * @param      item  The item
	 */
	public void add(final Team item) {
		//Inserts the specified element at the end of the list.
		//You can modify the code in this method.
		teams[size++] = item;
	}
	public String toString() {
		String s = "";
		for (int i = 0; i < size; i++) {
			s += teams[i].teamname + ",";
		}
		return s.substring(0, s.length() - 1);
	}
}
class SelectionSort {
	Teams team = new Teams();
	Team[] sort(Teams team) {
		for (int i = 0; i < team.size - 1; i++) {
			int index = i;
			for (int j = i + 1; j < team.size; j++) {
				if (less(team.teams, j, index)) {
					index = j;
				}
			}
			exch(team.teams, i , index);
		}
		return team.teams;
	}
	void exch(Team[] t, int i, int j) {
		Team t1 = team.teams[j];
		team.teams[j] = team.teams[i];
		team.teams[i] = t1;
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
		Team[] te = s.sort(t);
		System.out.println(te);
	}
}