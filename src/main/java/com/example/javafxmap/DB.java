package com.example.javafxmap;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/users";
        String userName = "root";
        String password = "";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
