module com.quizplus.tasktwo {
    requires javafx.controls;
    requires javafx.fxml;
    requires hibernate.jpa;
    
    requires hibernate.core;
    requires lombok;


    opens com.quizplus.tasktwo to javafx.fxml;
    exports com.quizplus.tasktwo;
}