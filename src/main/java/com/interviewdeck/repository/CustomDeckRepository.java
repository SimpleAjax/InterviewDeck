package com.interviewdeck.repository;

import com.interviewdeck.models.Company;
import com.interviewdeck.models.Deck;

import java.util.List;

public interface CustomDeckRepository {
    List<Deck> searchByText(Company company, String text);
}
