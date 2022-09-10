package com.interviewdeck.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignupStatusDTO {
    String message;
    Boolean status;
    String username;
}
