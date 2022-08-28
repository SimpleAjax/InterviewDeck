package com.interviewdeck.models;

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

    @OneToOne
    UserContentPage userContentPage;

}
