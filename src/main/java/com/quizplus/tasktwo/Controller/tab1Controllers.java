package com.quizplus.tasktwo.Controller;

import com.quizplus.tasktwo.Main;
import com.quizplus.tasktwo.Models.Course;
import com.quizplus.tasktwo.Rerpositry.CourseRepo;
import com.quizplus.tasktwo.Service.courseService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;

public class tab1Controllers  {
    List<Course> courses;
    ObservableList<String> ListObserv = FXCollections.observableArrayList();
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    CourseRepo courseRepo = new CourseRepo(entityManager);
    courseService courseService = new courseService(courseRepo);
    @FXML private Button Get;
    @FXML private TextField txt;
    @FXML private ListView<String> list;

    public void getCourses(ActionEvent actionEvent) {
         courses=  courseService.findall();

        for(int i=0;i<courses.size();i++){
            ListObserv.add(courses.get(i).getCourseName());
        }
        for (int i=0;i<ListObserv.size();i++){
            list.getItems().add(ListObserv.get(i));
        }

    }

    public void deleteCourses(ActionEvent actionEvent) {
        int selected = list.getSelectionModel().getSelectedIndex();
        if (list.getSelectionModel().getSelectedIndex()>=0){
            System.out.println(selected+"index");
            list.getItems().remove(selected);
            int index = list.getSelectionModel().getSelectedIndex();
            int courseId =  index + 1 ;
            try{
                System.out.println(courseId);
                courseService.deleateById(courseId);
            }
            catch (Exception ex){
                System.out.println("this id has been alredy deleted");
            }

        }
        else {
            String str = txt.getText();
            int num = Integer.parseInt(str);
            try{
                System.out.println(num);
                courseService.deleateById(num);
            }
            catch (Exception ex){
                System.out.println("this id has been alredy deleted");
            }
        }

    }



    public void ListView(ListView.EditEvent<String> stringEditEvent) {
        System.out.println(list.getSelectionModel().selectionModeProperty().toString());
    }


    public void Add(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AddCourse.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("Add Course !");
        stage.setScene(scene);
        stage.show();

    }

    public void Update(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("UpdateCourse.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("Update Course !");
        stage.setScene(scene);
        stage.show();
    }
}



