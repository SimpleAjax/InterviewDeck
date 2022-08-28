package com.interviewdeck.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Round extends BaseModel {
    @ManyToOne
    Deck deck;
    String roundName;
    @OneToMany
    List<Question> questionList;
}
