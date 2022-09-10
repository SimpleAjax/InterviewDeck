package com.interviewdeck.repository;

import com.interviewdeck.models.Deck;
import com.interviewdeck.models.Round;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundRepository extends CrudRepository<Round,Long> {
}
