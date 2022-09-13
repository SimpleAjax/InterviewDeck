package com.interviewdeck.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
public class LoginDTO {
    @NonNull
    String username;
    @NonNull
    String password;
    @Override
    public String toString() {
        return "LoginDTO{" +
                "userName='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
