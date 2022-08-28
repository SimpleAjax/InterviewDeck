package com.interviewdeck.repository;

import com.interviewdeck.models.Company;
import com.interviewdeck.models.UserContentPage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserContentPageRepository extends CrudRepository<UserContentPage, Long> {
//    List<Company> findByNameLike(String CompanyName);
}
