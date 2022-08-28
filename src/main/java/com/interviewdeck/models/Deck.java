package com.interviewdeck.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
@Entity
@Getter
@Setter
public class Deck extends BaseModel {
    @OneToOne
    User owner;
    String deckName;
    @OneToOne
    Company company;
    @OneToOne
    JobRole jobRole;
    Boolean isAnonymous;
    String interviewReview;
    String deckDescription;
    @OneToMany
    List<Round> rounds;



}
