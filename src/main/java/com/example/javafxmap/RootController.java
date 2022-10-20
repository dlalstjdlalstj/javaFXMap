package com.example.javafxmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
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
import javafx.scene.text.Font;

public class RootController implements Initializable {

    @FXML Button user;
    @FXML Button manager;
    @FXML TextField getID;
    @FXML PasswordField getPW;
    @FXML TextField getPhoneNum;
    @FXML TextField getName;
    @FXML Label UserSignUp;
    @FXML Button home;
    @FXML PasswordField inputPW;
    @FXML TextField inputID;
    @FXML Button loginOK;

    int checkNum = -1;
    @FXML PasswordField confirmPW;
    @FXML Button submitBtn;
    @FXML Label title;
    @FXML VBox vbox;
    @FXML Label UserLogin;
    @FXML ImageView firstBackImage;
    @FXML Pane firstBackColor;
    @FXML ImageView loginBackImage;
    @FXML Pane loginBackColor;
    @FXML ImageView usersignupBackImage;
    @FXML Pane usersignupBackColor;
    @FXML ImageView managerloginBackImage;
    @FXML Pane managerloginBackColor;
    @FXML TextField inputManagerID;
    @FXML PasswordField inputManagerPW;
    @FXML Button home2;
    @FXML Button checkExistBtn;
    @FXML Button managerOK;
    @FXML Label ManagerLogin;
    @FXML Label UserSignupLabel;

    Socket socket;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        //클라이언트 소켓 생성
//        if(!MyInfo.socketConnect) {
//
//            final String SERVER_IP = "192.168.0.83";
//
//            final int SERVER_PORT = 8080;
//
//            socket = new Socket();
//
//            try {
//                socket.connect( new InetSocketAddress(SERVER_IP, SERVER_PORT) );
//                System.out.println("success connection to server");
//                MyInfo.setConnect(true);
//                MyInfo.setSocket(socket);
//            }
//
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

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

    @FXML public void goUserSignUp(){
        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("UserSignUP.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) UserSignUp.getScene().getWindow();
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML public void submitUserSignup(){
        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("firsts.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) submitBtn.getScene().getWindow();
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
