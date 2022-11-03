package Rerpositry;

import Models.Course;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import java.util.List;

public class courseRepo {
    private EntityManager entityManager;
    public courseRepo(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    public List<Course> finaAll() {
        Session currSession = entityManager.unwrap(Session.class);
        Query<Course> query = currSession.createQuery("select * from course",Course.class);
        List<Course> course = query.getResultList();

        return course;
    }


    public Course findById(int theId) {
        Session currSession = (Session) entityManager.unwrap(Course.class);
        Course course = currSession.get(Course.class,theId);

        return course;
    }


    public void save(Course theCourse) {
       Session currSession = (Session) entityManager.unwrap(Course.class);
       currSession.saveOrUpdate(theCourse);
    }


    public void deleateById(int theId) {
        Session currSesion = (Session) entityManager.unwrap(Course.class);
        Query query = currSesion.createQuery(
                "delete from course where id=:courseId");
        query.setParameter("courseID",theId);


    }
}
