module com.example.javafxmap {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;


    opens com.example.javafxmap to javafx.fxml;
    exports com.example.javafxmap;
}