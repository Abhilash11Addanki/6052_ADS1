class StudentInfo implements Comparable<StudentInfo>{
	String studentname;
	int dateofbirth;
	int marks1;
	int marks2;
	int marks3;
	int totalmarks;
	String reservationcat;
	StudentInfo(String n, int dob, int m1, int m2, int m3, int total, String r) {
		studentname = n;
		dateofbirth = dob;
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
		if (dateofbirth > s.dateofbirth) {
			return 1;
		}
		if (dateofbirth < s.dateofbirth) {
			return -1;
		}
		return 0;
	}
	public String toString() {
		return studentname + "," + Integer.toString(totalmarks) + "," + reservationcat;
	}
}