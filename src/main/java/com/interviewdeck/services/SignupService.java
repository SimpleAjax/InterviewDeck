package com.interviewdeck.services;

import com.interviewdeck.dtos.SignUpDTO;
import com.interviewdeck.models.User;
import com.interviewdeck.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    @Autowired
    UserRepository userRepository;

    public String signup(SignUpDTO signUpDTO){
        User user=User.ConvertUserDTO(signUpDTO);
        User saveduser= userRepository.save(user);
        return saveduser.getUserName();
    }
}
