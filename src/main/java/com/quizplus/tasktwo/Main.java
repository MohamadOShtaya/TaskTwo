package com.quizplus.tasktwo;

import com.quizplus.tasktwo.Models.Course;
import com.quizplus.tasktwo.Rerpositry.CourseRepo;
import com.quizplus.tasktwo.Service.courseService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;

public class Main extends Application {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        CourseRepo cr = new CourseRepo(entityManager);
        courseService cs = new courseService(cr);
        Course course = new Course("C","Abdallah",10,null,true);
        Course course2 = new Course("loa","adc",10,null,true);
////        cr.save(course);
//      //  cs.findall();
//        System.out.println(cs.findall().toString());
        List<Course> test = cs.findall();
        System.out.println(test.toString());

//       // cr.deleteById(4);
//        cs.findById(2);
//        cs.deleateById(2);
//        Course course3 = new Course("up","adc",10,null,true);
//        cr.save(course2);
//        course3.setCourseName("after");
//       // cr.update(course3);
//        System.out.println( cr.findById(1).toString());

       // System.out.println(cs.findall().toString());
//        cs.deleateById(2);

//        List<Student> studentList = new ArrayList<>();
//        Student ss = new Student();
//        ss.setStudentAvg(75.5);
//        ss.setStudentDepartmentName("Quizplus");
//        ss.setStudentName("mohamad");
//        ss.setStudentGender("male");
//
//        studentList.add(ss);
//
//        Course cc = new Course();
//        cc.setAvilable(true);
//        cc.setDate(null);
//        cc.setTeacherName("mahde");
//        cc.setCourseCapacity(20);
//        cc.setCourseName("java");
//
//        List<Course> courses = new ArrayList<>();
//        courses.add(cc);
//        ss.setCourses(courses);
//        entityManager.getTransaction().begin();
//        entityManager.persist(cc);



        launch();
    }
}