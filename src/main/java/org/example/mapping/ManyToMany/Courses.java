package org.example.mapping.ManyToMany;

import jakarta.persistence.*;


@Entity
@Table(name = "course_info")
public class Courses {
    @Id
    @Column(name = "course_id")
    private int courseId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "course_price")
    private int coursePrice;

    public Courses() {
        System.out.println("Course constructor called..");
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(int coursePrice) {
        this.coursePrice = coursePrice;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", coursePrice=" + coursePrice +
                '}';
    }
}
