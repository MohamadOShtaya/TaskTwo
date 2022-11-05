package com.quizplus.tasktwo.Rerpositry;



import com.quizplus.tasktwo.Models.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import javax.persistence.EntityManager;
import java.util.List;


public class StudentRepo {

    private EntityManager entityManager;
    public StudentRepo(EntityManager entityManager){
        this.entityManager=entityManager;
    }


    public List<Student> finaAll() {
        Session session = (Session) entityManager.unwrap(Student.class);
        Query<Student> query = session.createQuery("from student",Student.class);
        List<Student> students = query.getResultList();
        return students;
    }


    public Student findById(int theId) {
        Session session = entityManager.unwrap(Session.class);
        Student student = session.get(Student.class, theId);
        return student;
    }


    public void save(Student theStudent) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(theStudent);
    }


    public void deleateById(int theId) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery(
                "delete from student where id=:studentId");
        query.setParameter("studentId", theId);
        query.executeUpdate();
    }
}
