package org.example.mapping.ManyToMany;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "students_info")
public class Students {
    @Id
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_city")
    private String studentCity;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Courses> coursesSet;

    public Students() {
        System.out.println("Students constructor called..");
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCity() {
        return studentCity;
    }

    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }

    public Set<Courses> getCoursesSet() {
        return coursesSet;
    }

    public void setCoursesSet(Set<Courses> coursesSet) {
        this.coursesSet = coursesSet;
    }


    @Override
    public String toString() {
        return "Students{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentCity='" + studentCity + '\'' +
                "coursesSet=" + coursesSet + '\''+
                '}';
    }
}
