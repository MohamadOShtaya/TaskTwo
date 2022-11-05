package com.quizplus.tasktwo.Models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity(name = "course")
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseId")
    private int courseId;
    @Column(name = "courseName")
    private String courseName;
    @Column(name = "teacherName")
    private String teacherName;
    @Column(name = "courseCapacity")
    private int courseCapacity;
    @Column(name = "date")
    private Date date;
    @Column(name = "isAvilable")
    private boolean isAvilable;
    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(
            name = "course_student",
            joinColumns=@JoinColumn(name = "course_id"),
            inverseJoinColumns=@JoinColumn(name = "student_id")
    )
    private List<Student> students;




    public  Course(){

   }

    public Course(String courseName, String teacherName, int courseCapacity, Date date, boolean isAvilable, List<Student> students) {
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.courseCapacity = courseCapacity;
        this.date = date;
        this.isAvilable = isAvilable;
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", courseCapacity=" + courseCapacity +
                ", date=" + date +
                ", isAvilable=" + isAvilable +
                ", students=" + students +
                '}';
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setCourseCapacity(int courseCapacity) {
        this.courseCapacity = courseCapacity;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAvilable(boolean avilable) {
        isAvilable = avilable;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public int getCourseCapacity() {
        return courseCapacity;
    }

    public Date getDate() {
        return date;
    }

    public boolean isAvilable() {
        return isAvilable;
    }

    public List<Student> getStudents() {
        return students;
    }
}
