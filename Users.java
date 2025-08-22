/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.medicine_reminder;

/**
 *
 * @author HP
 */
public class Users {

    private int userId;
    private String name;
    private String password;
    private String email;
    private String created_at;
    private String modified_at;

    public Users() {
    }

    public Users(int userId, String name, String password, String email, String created_at, String modified_at) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getModified_at() {
        return modified_at;
    }

    public void setModified_at(String modified_at) {
        this.modified_at = modified_at;
    }

    @Override
    public String toString() {
        return "Users{" + "userId=" + userId + ", name=" + name + ", password=" + password + ", email=" + email + ", created_at=" + created_at + ", modified_at=" + modified_at + '}';
    }

   
}
