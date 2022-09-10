package com.interviewdeck.dtos;

import com.interviewdeck.models.*;
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

    public static Deck convertToDeck(DeckDTO deckDTO){
        Deck deck=new Deck();
        deck.setOwner(deckDTO.getOwner());
        deck.setDeckName(deckDTO.getDeckName());
        deck.setCompany(deckDTO.getCompany());
        deck.setIsAnonymous(deckDTO.getIsAnonymous());
        deck.setInterviewReview(deckDTO.getInterviewReview());
        deck.setDeckDescription(deckDTO.getDeckDescription());
        deck.setRounds(deckDTO.getRounds());
        return deck;
    }
}
