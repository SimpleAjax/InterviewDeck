package com.interviewdeck.dtos;

import com.interviewdeck.models.Company;
import com.interviewdeck.models.JobRole;
import com.interviewdeck.models.Round;
import com.interviewdeck.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DeckDTO {
    long id;
    User owner;
    String deckName;
    Company company;
//    JobRole jobRole;
    Boolean isAnonymous;
    String interviewReview;
    String deckDescription;
    List<Round> rounds;
}
