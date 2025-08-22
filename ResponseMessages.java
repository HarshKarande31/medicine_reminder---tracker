package com.qt.medicine_reminder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public enum ResponseMessages {
    DATA_ADDED("Data added successfully"),
    DATA_UPDATED("Data updated successfully"),
    DATA_DELETED("Data deleted successfully"),
    NAME_NOT_NULL("Name cannot be empty"),
    EMAIL_NOT_NULL("Email cannot be empty"),
    ADDRESS_NOT_NULL("Address cannot be empty"),
    PHONE_NOT_NULL("Phone cannot be empty"),
    PASS_NOT_NULL(" password cannot be empty"),
    BRANCH_NOT_NULL("Branch cannot be empty");

    private String message;

    private ResponseMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


