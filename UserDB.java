/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.medicine_reminder;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HP
 */
public class UserDB {

    private static final String DATABASE = "medicine_reminder";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection connectDB() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return connection;
    }

}
