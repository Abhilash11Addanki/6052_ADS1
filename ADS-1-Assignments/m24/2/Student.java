/**
 * Class for student.
 */
class Student implements Comparable<Student> {
    /**
     * roll number of Student.
     */
    private String rollnumber;
    /**
     * name of the Student.
     */
    private String studentname;
    /**
     * total marks of the Student.
     */
    private double totalmarks;
    /**
     * Constructs the object.
     * @param      roll   The roll
     * @param      name   The name
     * @param      marks  The marks
     */
    Student(final String roll, final String name,
        final double marks) {
        rollnumber = roll;
        studentname = name;
        totalmarks = marks;
    }
    /**
     * Gets the roll number.
     * @return     The roll number.
     */
    String getRollNumber() {
        return rollnumber;
    }
    /**
     * Gets the student name.
     * @return     The student name.
     */
    String getStudentName() {
        return studentname;
    }
    /**
     * Gets the total marks.
     * @return     The total marks.
     */
    double getTotalMarks() {
        return totalmarks;
    }
    /**
     * compareTo method that compares the marks
     * and then roll number.
     * @param      s     s of type Student.
     * @return     integer.
     */
    public int compareTo(final Student s) {
        if (totalmarks > s.totalmarks) {
            return 1;
        }
        if (totalmarks < s.totalmarks) {
            return -1;
        }
        return rollnumber.compareTo(s.rollnumber);
    }
}
