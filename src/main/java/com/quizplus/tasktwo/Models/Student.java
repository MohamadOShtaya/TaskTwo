package com.quizplus.tasktwo.Models;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity(name = "student")
@Table(name = "student")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private int studentId;
    @Column(name = "studentName")
    private String studentName;
    @Column(name = "studentGender")
    private String studentGender;
    @Column(name = "studentAvg")
    private double studentAvg;
    @Column(name = "studentDepartmentName")
    private String studentDepartmentName;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(
            name = "course_student",
            joinColumns=@JoinColumn(name = "student_id"),
            inverseJoinColumns=@JoinColumn(name = "course_id")
    )
    List<Course> courses = new ArrayList<>();


    public Student(){

    }

    public Student(String studentName, String studentGender, double studentAvg, String studentDepartmentName, List<Course> courses) {
        this.studentName = studentName;
        this.studentGender = studentGender;
        this.studentAvg = studentAvg;
        this.studentDepartmentName = studentDepartmentName;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentGender='" + studentGender + '\'' +
                ", studentAvg=" + studentAvg +
                ", studentDepartmentName='" + studentDepartmentName + '\'' +
                ", courses=" + courses +
                '}';
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public void setStudentAvg(double studentAvg) {
        this.studentAvg = studentAvg;
    }

    public void setStudentDepartmentName(String studentDepartmentName) {
        this.studentDepartmentName = studentDepartmentName;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public double getStudentAvg() {
        return studentAvg;
    }

    public String getStudentDepartmentName() {
        return studentDepartmentName;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
