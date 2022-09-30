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
        browser.load("https://dangdangmap.net/pet/tour/map");
    }
}