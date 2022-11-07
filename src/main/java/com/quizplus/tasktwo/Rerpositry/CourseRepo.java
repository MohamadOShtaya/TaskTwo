package com.quizplus.tasktwo.Rerpositry;

import com.quizplus.tasktwo.Models.Course;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


public class CourseRepo {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    public CourseRepo(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    public List<Course> finaAll() {

        entityManager.createQuery("from course").getResultList();
//        entityManager.getTransaction().commit();
        return entityManager.createQuery("from course ").getResultList();
    }
    public void save(Course theCourse) {
         entityManager.getTransaction().begin();
         entityManager.persist(theCourse);
         entityManager.getTransaction().commit();
    }

    public Course findById(int theId) {
        Course course = entityManager.find(Course.class,theId);
        return course;

    }
    public void deleteById(int courseId){
        entityManager.getTransaction().begin();
        try {
            Course course = entityManager.find(Course.class,courseId);
            entityManager.remove(course);
            entityManager.getTransaction().commit();
            System.out.println("Deleated");
        }
        catch (Exception ex){
            System.out.println("Course has already been delated ");
        }


    }
    public void Put(int id){
        findById(id);
        Course course = findById(id);
        String newcourseName = course.getCourseName();
        String newteacherName = course.getTeacherName();
        int newcapacity = course.getCourseCapacity();
        boolean newisAvilable = course.isAvilable();
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("update course set courseName=:newcourseName" +
                    ",teacherName=: newteacherName" +
                    ",courseCapacity=:newcapacity" +
                    ",isAvilable=:newisAvilable where courseId=:id").executeUpdate();
        }
        catch (Exception ex){

        }
    }
    public void update(Course course){
        entityManager.getTransaction().begin();
         course= (Course) entityManager.find(Course.class , course.getCourseId());


        entityManager
                .createQuery("update course set courseName =  course.getCourseName()" +
                        ", teacherName =course.getTeacherName()" +
                        ",courseCapacity= course.getCourseCapacity() " +
                        ",date_=course.getDate()" +
                        ",isAvilable=course.isAvilable()" +
                        " where id=" +
                        "course.getCourseId()")
                .executeUpdate();



       

    }




}
