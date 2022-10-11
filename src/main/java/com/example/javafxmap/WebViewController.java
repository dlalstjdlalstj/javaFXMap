package com.example.javafxmap;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class WebViewController {
    @FXML
    private WebView webView;

    private WebEngine browser;

    @FXML
    private void initialize() {
        browser = webView.getEngine();
        browser.load("http://localhost:63342/javaFXMap/com/example/javafxmap/index.html?_ijt=v1jpl8kmado64cq4r96dbds7s7&_ij_reload=RELOAD_ON_SAVE");
    }
}