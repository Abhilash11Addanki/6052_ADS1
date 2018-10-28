/**
 * Class for student.
 */
class Student implements Comparable<Student> {
    /**
     * roll number of Student.
     */
    private String roll_number;
    /**
     * name of the Student.
     */
    private String student_name;
    /**
     * total marks of the Student.
     */
    private double total_marks;
    /**
     * Constructs the object.
     * @param      roll   The roll
     * @param      name   The name
     * @param      marks  The marks
     */
    Student(final String roll, final String name,
        final double marks) {
        roll_number = roll;
        student_name = name;
        total_marks = marks;
    }
    /**
     * Gets the roll number.
     * @return     The roll number.
     */
    String getRollNumber() {
        return roll_number;
    }
    /**
     * Gets the student name.
     * @return     The student name.
     */
    String getStudentName() {
        return student_name;
    }
    /**
     * Gets the total marks.
     * @return     The total marks.
     */
    double getTotalMarks() {
        return total_marks;
    }
    /**
     * compareTo method that compares the marks
     * and then roll number.
     * @param      s     s of type Student.
     * @return     integer.
     */
    public int compareTo(final Student s) {
        if (total_marks > s.total_marks) {
            return 1;
        }
        if (total_marks < s.total_marks) {
            return -1;
        }
        return roll_number.compareTo(s.roll_number);
    }
    /**
     * Returns a string representation of the object.
     * @return     String representation of the object.
     */
    public String toString() {
        return roll_number + student_name
        + Double.toString(total_marks);
    }
}
