package com.interviewdeck.repository;

import com.interviewdeck.models.Company;
import com.interviewdeck.models.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeckRepository extends JpaRepository<Deck, Integer> {

    List<Deck> getByCompany(Company company);

}
