class Student {
    String roll_number;
    String student_name;
    double total_marks;
    Student(String number, String name, double marks) {
        roll_number = number;
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
    String toString() {
        return roll_number + student_name + Double.toString(getTotalMarks);
    }
}
