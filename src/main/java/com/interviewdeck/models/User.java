package com.interviewdeck.models;

import com.interviewdeck.dtos.SignUpDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//@Entity
@Setter
@Getter
@Table(name = "DeckUsers")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseModel{
    @Column(unique = true)
    String userName;
    String password;
    String firstName;
    String lastname;
    String salt;
    @OneToOne
    UserContentPage userContentPage;

    public static User ConvertUserDTO(SignUpDTO signUpDTO){
        User user= new User();
        user.setUserName(signUpDTO.getUsername());
        user.setPassword(signUpDTO.getPassword());
        user.setFirstName(signUpDTO.getFirstName());
        user.setLastname(signUpDTO.getLastName());
        return user;
    }

    public static User getUser(String userName, UserContentPage page){
        return new User(userName,"pwd"+userName,"firstname","lastname","salt", page);
    }

}
