package com.interviewdeck.services;

import com.interviewdeck.dtos.SignUpDTO;
import com.interviewdeck.dtos.SignupStatusDTO;
import com.interviewdeck.models.User;
import com.interviewdeck.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    @Autowired
    UserRepository userRepository;

    public ResponseEntity<SignupStatusDTO> signup(SignUpDTO signUpDTO){
        User user=User.ConvertUserDTO(signUpDTO);
        User saveduser= userRepository.save(user);
        if(saveduser.getUserName().isEmpty()){
            return ResponseEntity.status(HttpStatus.IM_USED).body( new SignupStatusDTO("The username already exists", false,user.getUserName()));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body( new SignupStatusDTO("Signup Successfull", false,user.getUserName()));
    }
}
