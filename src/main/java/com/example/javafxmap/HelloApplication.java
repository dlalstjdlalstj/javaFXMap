package com.example.javafxmap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class HelloApplication extends Application
{
    @Override
    public void start(Stage primaryStage) {
        WebView browser = new WebView();

        WebEngine webEngine = browser.getEngine();

        webEngine.load("http://localhost:63342/javaFXMap/com/example/javafxmap/index.html?_ijt=ma3vt21s09dg9rn2sf11iajarg");

        StackPane root = new StackPane();
        root.getChildren().add(browser);

        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.setMaximized(true);
        primaryStage.setTitle("댕댕맵");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}