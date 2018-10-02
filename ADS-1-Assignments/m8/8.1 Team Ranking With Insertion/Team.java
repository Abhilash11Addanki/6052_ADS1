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