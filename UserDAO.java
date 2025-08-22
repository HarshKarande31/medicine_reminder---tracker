/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.medicine_reminder;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class UserDAO {

    //To insert users
    public String insert(Users user) {
        String message = null;
        Connection con = null;
        CallableStatement cs = null;
        String sql = "Insert into user(userId, name, password, email) Values(?,?,?,?)";

        try {
            con= UserDB.connectDB();
            cs = con.prepareCall(sql);

            cs.setInt(1, user.getUserId());
            cs.setString(2, user.getName());
            cs.setString(3, user.getPassword());
            cs.setString(3, user.getEmail());

            int rows = cs.executeUpdate();
            if (rows >= 1) {
                message = "Data is successfully inserted";
            }
        } catch (Exception e) {
            System.out.print("UserDAO.insert: " + e.getMessage());
            message = e.getMessage();
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (con != null);
            } catch (Exception e) {
            }
        }
        return message;
    }

    //To fetch users
    public ArrayList<Users> findAll() {
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        ArrayList<Users> userList = new ArrayList<>();
        String sql = "Select *from users";

        try {
            //  con=medicine_remainder.connectDB();
            cs = con.prepareCall(sql);
            rs = cs.executeQuery();

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
            System.out.println("UserDAO.findALL() : " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (cs != null) {
                    cs.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
        }
        return userList;
    }

}
