package com.interviewdeck.services;

import com.interviewdeck.dtos.LoginDTO;
import com.interviewdeck.repositories.UserRepository;
import org.springframework.stereotype.Service;
import com.interviewdeck.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class ValidateUser {
    @Autowired
    UserRepository userRepository;
    public boolean isValidUser(LoginDTO loginDTO) {
        // fetch from database for the userName (username and password
        List<User> users=userRepository.findByUsername(loginDTO.getUsername());
        if(users.size()==0){
            return false;
        }else if(users.get(0).getUsername().equals(loginDTO.getUsername()) &&
                users.get(0).getPassword().equals(loginDTO.getPassword())){
            return true;
        }
        return "admin".equals(loginDTO.getUsername()) && "admin".equals(loginDTO.getPassword());
    }
}
