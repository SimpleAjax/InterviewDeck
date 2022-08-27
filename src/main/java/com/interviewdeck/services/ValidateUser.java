package com.interviewdeck.services;

import com.interviewdeck.dtos.LoginDTO;

public class ValidateUser {
    public static boolean isValidUser(LoginDTO loginDTO) {
        // fetch from database for the userName (username and password
        System.out.println(loginDTO.toString());
        String userName="", password="";
        return "user1".equals(userName) && "pwd".equals(password);
    }
}
