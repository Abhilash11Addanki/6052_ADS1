class Student implements Comparable<Student> {
	private String roll_number;
	private String student_name;
	private double total_marks;
	Student(String roll, String name, double marks) {
		roll_number = roll;
		student_name = name;
		total_marks = marks;
	}
	String getRollNumber() {
		return roll_number;
	}
	String getStudentName() {
		return student_name;
	}
    double getTotalMarks() {
    	return total_marks;
    }
	public int compareTo(final Student s) {
		if (total_marks > s.total_marks) {
			return 1;
		}
		if (total_marks < s.total_marks) {
			return -1;
		}
		return roll_number.compareTo(s.roll_number);
	}
	public String toString() {
		return roll_number + student_name + Double.toString(total_marks);
	}
}