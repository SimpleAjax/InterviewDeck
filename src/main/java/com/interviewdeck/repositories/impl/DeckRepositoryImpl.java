package com.interviewdeck.repositories.impl;

import com.interviewdeck.models.Company;
import com.interviewdeck.repositories.CustomDeckRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class DeckRepositoryImpl implements CustomDeckRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List searchByText(Company company, String text) {
        return  entityManager.createQuery("FROM Deck deck where " +
                "( deck.company = :company or :company is null) and " +
                "( LOWER(deck.deckDescription) LIKE LOWER(CONCAT('%', :text, '%')) or :text is null) ")
                .setParameter("company", company)
                .setParameter("text", text)
                .getResultList();
    }
}
