package com.example.javafxmap;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MainController {
    @FXML
    private WebView webView;

    private WebEngine browser;

    @FXML
    private void initialize() {
        browser = webView.getEngine();
        browser.load("http://localhost:63342/javaFXMap/com/example/javafxmap/index.html?_ijt=php2objv56d1bpmcj9ph2fajd6");
    }

}