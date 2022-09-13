package com.interviewdeck.services;

import com.interviewdeck.dtos.SignUpDTO;
import com.interviewdeck.dtos.SignupStatusDTO;
import com.interviewdeck.models.User;
import com.interviewdeck.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SignupService {
    @Autowired
    UserRepository userRepository;

    public ResponseEntity<SignupStatusDTO> signup(SignUpDTO signUpDTO){
        User user=User.ConvertUserDTO(signUpDTO);

        List<User> optionalUser=userRepository.findByUsername(user.getUsername());
        if(optionalUser.size()>0){
            throw new ResponseStatusException(
                    HttpStatus.IM_USED, "User with id:"+user.getId()+" is already present");
        }
        User savedUser= userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body( new SignupStatusDTO("Signup Successfull", true,user.getUsername()));
    }
}
