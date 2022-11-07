package com.quizplus.tasktwo.Controller;

import com.quizplus.tasktwo.Models.Course;
import com.quizplus.tasktwo.Rerpositry.CourseRepo;
import com.quizplus.tasktwo.Service.courseService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class tab1Controllers  {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    CourseRepo courseRepo = new CourseRepo(entityManager);
    courseService courseService = new courseService(courseRepo);
    @FXML private Button Get;
    @FXML private TextField txt;
    @FXML private ListView<String> list;

    public void deleteCourses(ActionEvent actionEvent) {
        String str = txt.getText();
        int num = Integer.parseInt(str);
        System.out.println(num);
        courseService.deleateById(num);
    }

    public void getCourses(ActionEvent actionEvent) {
       List<Course> courses=  courseService.findall();
       ObservableList<String> ListObserv = FXCollections.observableArrayList();
       for(int i=0;i<courses.size();i++){
           ListObserv.add(courses.get(i).getCourseName());
       }
       for (int i=0;i<ListObserv.size();i++){
           list.getItems().add(ListObserv.get(i));
       }

    }

    public void ListView(ListView.EditEvent<String> stringEditEvent) {
        System.out.println(list.getSelectionModel().selectionModeProperty().toString());
    }



//        public void deleteCourses(){
//           String str = txt.getText();
//            courseService.deleateById(Integer.parseInt(str));
//
//        }




    }



