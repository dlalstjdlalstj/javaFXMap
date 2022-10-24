package com.example.javafxmap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class RootController {
    @FXML
    private TextField id;
    @FXML
    private TextField pw;
    @FXML
    private Button LoginBtn;

    public void LoginAction(ActionEvent event) {
        String ID = this.id.getText();
        String PW = this.pw.getText();
        String Url = "jdbc:mysql://127.0.0.1:3306/users";
        String bID = "root";
        String dPW = "";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(Url, bID, dPW);
            sql = "select id,password from user where id = ? and password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ID);
            pstmt.setString(2, PW);
            rs = pstmt.executeQuery();
            if (rs.next()) {
            }
            if (rs.getString("id").equals(ID) && rs.getString("pw").equals(PW)) {
                Parent nextScene
                        = FXMLLoader.load(getClass().getResource("MainLayout.fxml"));
                Scene scene = new Scene(nextScene);
                Stage primaryStage = (Stage) LoginBtn.getScene().getWindow();
                primaryStage.setScene(scene);
            }
        } catch (Exception var25) {
            var25.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();

                } catch (SQLException ver24) {

                }
            }
            if (conn != null) {

                try {
                    conn.close();

                } catch (SQLException var23) {
                }
            }
        }
    }
    @FXML
    private Label sign;
    @FXML
    private Button login2;

    public void signScene() {

        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("UserSignUp.fxml"));
            Scene scene = new Scene(nextScene);
            Stage stage = (Stage) sign.getScene().getWindow();
            stage.setScene(scene);

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    public void insertMember() {
        DB db = new DB();

        Connection conn = db.getConnection();

        PreparedStatement pstmt = null;

        String sql = "INSERT INTO user(id, password) VALUES(?,?)";

        try {

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id.getText());
            pstmt.setString(2, pw.getText());
            pstmt.executeUpdate();

            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("firsts.fxml"));
            Scene scene = new Scene(nextScene);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            Stage stage = (Stage) login2.getScene().getWindow();
            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

