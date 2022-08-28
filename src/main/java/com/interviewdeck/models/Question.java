package com.interviewdeck.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Question extends BaseModel {
    @ManyToOne
    Round round;
    String question;
    String answer;
}
