package com.interviewdeck.repository;

import com.interviewdeck.models.Company;
import com.interviewdeck.models.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DeckRepository extends JpaRepository<Deck, Long> {

    List<Deck> getByCompany(Company company);

}
