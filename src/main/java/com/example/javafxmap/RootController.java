package com.example.javafxmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class RootController {

    @FXML Button user;
    @FXML Button UserSignUp;
    @FXML PasswordField inputPW;
    @FXML TextField inputID;
    @FXML Button loginOK;

    @FXML VBox vbox;
    @FXML Label UserLogin;
    @FXML ImageView loginBackImage;
    @FXML Pane loginBackColor;

    public static Connection Connect() {
        String url = "jdbc:mysql://localhost:3306/yydh";
        String userName = "root";
        String password = "";
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, userName, password);
        }
        catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    @FXML public void moveUser() throws Exception{
        Stage primaryStage = new Stage();
        Stage stage = (Stage)user.getScene().getWindow();

        Parent second = FXMLLoader.load(getClass().getResource("templates/login.fxml"));
        Scene sc = new Scene(second);
        sc.getStylesheets().add(getClass().getResource("statics/login.css").toExternalForm());
        primaryStage.setScene(sc);
        primaryStage.show();
        stage.close();
    }

    //manager login으로 이동
    @FXML public void moveManager() throws Exception{
        Stage primaryStage = new Stage();
        Stage stage = (Stage)user.getScene().getWindow();

        Parent second = FXMLLoader.load(getClass().getResource("templates/managerLogin.fxml"));
        second.getStylesheets().add(getClass().getResource("statics/managerLogin.css").toExternalForm());
        Scene sc = new Scene(second);
        primaryStage.setScene(sc);
        primaryStage.show();
        primaryStage.setResizable(false);
        stage.close();
    }

    //user login 버튼 이벤트
    @FXML public void UserLogin(ActionEvent event) throws Exception {

        //항목이 비어있는 경우 오류
        if(inputPW.getText().equals("")) {
            Alert loginFail = new Alert(AlertType.ERROR);
            loginFail.setHeaderText("Empty error");
            loginFail.setContentText("Pleas input ID or Password");
            loginFail.showAndWait();
        }

        //text field에 입력받은 id를 서버로 보내고, id에 해당하는 pw를 서버에서 받아온다.
        String passwordDB = null;
        if(passwordDB.equals(inputPW.getText())) {

            System.out.println("login success");
            Stage primaryStage = new Stage();
            Stage stage = (Stage)loginOK.getScene().getWindow();

            Parent UserPage = FXMLLoader.load(getClass().getResource("/user/templates/userMain.fxml"));
            UserPage.getStylesheets().add(getClass().getResource("/user/statics/userMain.css").toExternalForm());
            Scene sc = new Scene(UserPage);
            primaryStage.setScene(sc);
            primaryStage.show();
            primaryStage.setResizable(false);
            stage.close();
        }
        else {
            Alert loginFail = new Alert(AlertType.ERROR);
            loginFail.setHeaderText("Login Fail");
            loginFail.setContentText("login fail");
            loginFail.showAndWait();
        }
    }

    @FXML public void goUserSignUp() throws Exception{

        Stage primaryStage = new Stage();
        Parent signUp = FXMLLoader.load(getClass().getResource("templates/UserSignup.fxml"));
        signUp.getStylesheets().add(getClass().getResource("statics/UserSignup.css").toExternalForm());
        primaryStage.setScene(new Scene(signUp));
        primaryStage.show();
        primaryStage.setResizable(false);

        Stage stage = (Stage)UserSignUp.getScene().getWindow();
        stage.close();
    }

    @FXML public void toHome() throws Exception {
        Stage primaryStage = new Stage();
        Stage stage = (Stage)UserLogin.getScene().getWindow();

        Parent ob = FXMLLoader.load(getClass().getResource("templates/first.fxml"));
        ob.getStylesheets().add(getClass().getResource("statics/first.css").toExternalForm());
        Scene sc = new Scene(ob);
        primaryStage.setScene(sc);
        primaryStage.show();
        primaryStage.setResizable(false);
        stage.close();
    }
}
