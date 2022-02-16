package com.example.demo.dtos;

import com.example.demo.entities.User;

import java.io.Serializable;

public class UserDTO extends User implements Serializable {

    private String currentPassword;

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                ", currentPassword='" + currentPassword + '\'' +
                '}';
    }
}
