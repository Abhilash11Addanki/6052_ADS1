class StudentInfo implements Comparable<StudentInfo>{
	String studentname;
	int year;
	int month;
	int date;
	int marks1;
	int marks2;
	int marks3;
	int totalmarks;
	String reservationcat;
	StudentInfo(String n, int y, int m, int d, int m1, int m2, int m3, int total, String r) {
		studentname = n;
		year = y;
		month = m;
		date = d;
		marks1 = m1;
		marks2 = m2;
		marks3 = m3;
		totalmarks = total;
		reservationcat = r;
	}
	public int compareTo(StudentInfo s) {
		if (totalmarks > s.totalmarks) {
			return 1;
		}
		if (totalmarks < s.totalmarks) {
			return -1;
		}
		if (marks3 > s.marks3) {
			return 1;
		}
		if (marks3 < s.marks3) {
			return -1;
		}
		if (marks2 > s.marks2) {
			return 1;
		}
		if (marks2 < s.marks2) {
			return -1;
		}
		if (year > s.year) {
			return 1;
		}
		if (year < s.year) {
			return -1;
		}
		if (month > s.month) {
			return 1;
		}
		if (month < s.month) {
			return -1;
		}
		if (date > s.date) {
			return 1;
		}
		if (date < s.date) {
			return -1;
		}
		return 0;
	}
	public String toString() {
		return studentname + "," + Integer.toString(totalmarks) + "," + reservationcat;
	}
}