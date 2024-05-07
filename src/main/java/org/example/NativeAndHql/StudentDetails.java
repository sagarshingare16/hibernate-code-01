package org.example.NativeAndHql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_details")
public class StudentDetails {
    @Id
    @Column(name = "student_roll_number")
    private int studentRollNumber;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_standard")
    private String studentStandard;
    @Column(name = "student_marks")
    private double studentMarks;

    public StudentDetails() {
        System.out.println("Student constructor called...");
    }

    public int getStudentRollNumber() {
        return studentRollNumber;
    }

    public void setStudentRollNumber(int studentRollNumber) {
        this.studentRollNumber = studentRollNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentStandard() {
        return studentStandard;
    }

    public void setStudentStandard(String studentStandard) {
        this.studentStandard = studentStandard;
    }

    public double getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(double studentMarks) {
        this.studentMarks = studentMarks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentRollNumber=" + studentRollNumber +
                ", studentName='" + studentName + '\'' +
                ", studentStandard='" + studentStandard + '\'' +
                ", studentMarks=" + studentMarks +
                '}';
    }
}
