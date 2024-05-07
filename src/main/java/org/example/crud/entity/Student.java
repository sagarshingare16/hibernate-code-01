package org.example.crud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_info")
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "student_std")
    private String studentStandard;
    @Embedded
    private StudentName studentName;
    @Embedded
    private StudentAddress studentAddress;

    public Student(){
        System.out.println("Student constructor called..");
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentStandard() {
        return studentStandard;
    }

    public void setStudentStandard(String studentStandard) {
        this.studentStandard = studentStandard;
    }

    public StudentName getStudentName() {
        return studentName;
    }

    public void setStudentName(StudentName studentName) {
        this.studentName = studentName;
    }

    public StudentAddress getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(StudentAddress studentAddress) {
        this.studentAddress = studentAddress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentStandard='" + studentStandard + '\'' +
                ", studentName=" + studentName +
                ", studentAddress=" + studentAddress +
                '}';
    }
}
