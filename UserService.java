/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.medicine_reminder;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class UserService {

    UserDAO userDAO = new UserDAO();

    public String insert(Users user) {
        return userDAO.insert(user);
    }

    public ArrayList<Users> findAll() {
        return userDAO.findAll();
    }

}
