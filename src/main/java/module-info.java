module com.quizplus.tasktwo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.compiler;
    requires java.sql;
    requires org.mapstruct;



    opens com.quizplus.tasktwo to javafx.fxml, org.hibernate.orm.core;
    exports com.quizplus.tasktwo;
    exports com.quizplus.tasktwo.Controller;
    opens com.quizplus.tasktwo.Controller to javafx.fxml, org.hibernate.orm.core;


}