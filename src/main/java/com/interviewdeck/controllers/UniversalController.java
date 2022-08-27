package com.interviewdeck.controllers;

import com.interviewdeck.dtos.LoginDTO;
import com.interviewdeck.services.ValidateUser;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UniversalController {

    @GetMapping("/status")
    public String status() {
        System.out.println("In the /status");
        return "OK";
    }

    @GetMapping("/error")
    public String error() {
        System.out.println("In the /errror");
        return "error";
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginDTO loginDTO, BindingResult result) {
        if(result.hasErrors()) {
            return "Found errors";
        }
        if(ValidateUser.isValidUser(loginDTO)) return "LOGGED IN";
        return "INVALID_USER / FAILED";
    }
}
