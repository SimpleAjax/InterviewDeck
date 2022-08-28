package com.interviewdeck.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//@Entity
@Setter
@Getter
@Table(name = "DeckUsers")
@Entity
public class User extends BaseModel{
    @Column(unique = true)
    String userName;
    @OneToOne
    Profile userProfile;
    @OneToOne
    UserContentPage userContentPage;
}
