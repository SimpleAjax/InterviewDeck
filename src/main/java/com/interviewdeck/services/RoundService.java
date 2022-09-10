package com.interviewdeck.services;

import com.interviewdeck.models.Deck;
import com.interviewdeck.models.Round;
import com.interviewdeck.repository.DeckRepository;
import com.interviewdeck.repository.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class RoundService {

    @Autowired
    static RoundRepository roundRepository;

    public static List<Round> deckRoundUpdation(Deck deck, List<Round> updatedRounds){
        List<Round> prevrounds=deck.getRounds();
        HashSet<Long> set= new HashSet<>();
        for(Round round: prevrounds){
            set.add(round.getId());
        }
        List<Round> newRounds= new ArrayList<>();
        for(Round round : updatedRounds){
            if(round.getRoundName().isEmpty() && set.contains(round.getId())){
                roundRepository.deleteById(round.getId());
            } else if (! set.contains(round.getId())) {
                newRounds.add(roundRepository.save(round));


            }else {
                newRounds.add(roundRepository.save(round));
            }

        }
        return newRounds;

    }
}
