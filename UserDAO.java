package com.qt.medicine_reminder;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO {

    // To insert users
    public String insert(Users user) {
        String message = null;
        Connection con = null;
        PreparedStatement ps = null; // Use PreparedStatement
        String sql = "INSERT INTO users(name, password, email) VALUES(?,?,?)";

        try {
            con = UserDB.connectDB();
            ps = con.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail()); // Corrected parameter index

            int rows = ps.executeUpdate();
            if (rows >= 1) {
                message = "Data is successfully inserted";
            }
        } catch (Exception e) {
            System.out.print("UserDAO.insert: " + e.getMessage());
            message = e.getMessage();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return message;
    }

    // To fetch users
    public ArrayList<Users> findAll() {
        Connection con = null;
        PreparedStatement ps = null; // Use PreparedStatement
        ResultSet rs = null;
        ArrayList<Users> userList = new ArrayList<>();
        String sql = "SELECT * FROM users"; // Corrected table name

        try {
            con = UserDB.connectDB();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                userList.add(new Users(
                        rs.getInt("userId"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                ));
            }
        } catch (Exception e) {
            System.out.println("UserDAO.findAll() : " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                 e.printStackTrace();
            }
        }
        return userList;
    }
}