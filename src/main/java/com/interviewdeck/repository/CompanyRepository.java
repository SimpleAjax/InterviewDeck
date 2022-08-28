package com.interviewdeck.repository;

import com.interviewdeck.models.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
    List<Company> findByNameLike(String CompanyName);
}
