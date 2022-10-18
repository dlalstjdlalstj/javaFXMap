package com.example.javafxmap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class first extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(first.class.getResource("firsts.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1365, 969);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setTitle("댕댕맵");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}