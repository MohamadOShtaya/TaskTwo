package com.quizplus.tasktwo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
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