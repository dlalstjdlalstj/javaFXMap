module com.example.javafxmap {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxmap to javafx.fxml;
    exports com.example.javafxmap;
}