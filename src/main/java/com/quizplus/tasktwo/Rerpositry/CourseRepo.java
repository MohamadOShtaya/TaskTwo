package com.quizplus.tasktwo.Rerpositry;

import com.quizplus.tasktwo.Models.Course;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class CourseRepo {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    public CourseRepo(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    public List<Course> finaAll() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("select c from course ").getResultList();
        entityManager.getTransaction().commit();
        return entityManager.createQuery("select c from course ").getResultList();
    }
    public void save(Course theCourse) {
//         entityManager.getTransaction().begin();
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
    public void update(Course course){
        entityManager.getTransaction().begin();
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(course);
    }




}
