package com.interviewdeck.models;

import com.interviewdeck.dtos.DeckDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Deck extends BaseModel {
    @OneToOne(fetch = FetchType.LAZY)
    User owner;
    String deckName;
    @ManyToOne
    Company company;
//    @OneToOne
//    JobRole jobRole;
    Boolean isAnonymous;
    String interviewReview;
    String deckDescription;
    @OneToMany
    List<Round> rounds;

    public static DeckDTO createDTO(Deck deck) {
        DeckDTO dto = new DeckDTO();

        dto.setId(deck.getId());
        dto.setOwner(deck.getOwner());
        dto.setDeckName(deck.getDeckName());
        dto.setCompany(deck.getCompany());
//        dto.setJobRole(deck.getJobRole());
        dto.setIsAnonymous(deck.getIsAnonymous());
        dto.setInterviewReview(deck.getInterviewReview());
        dto.setDeckDescription(deck.getDeckDescription());
        dto.setRounds(deck.getRounds());

        return dto;
    }

}
