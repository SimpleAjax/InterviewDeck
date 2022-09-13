package com.interviewdeck.repositories;

import com.interviewdeck.models.UserContentPage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserContentPageRepository extends CrudRepository<UserContentPage, Long> {
//    List<Company> findByNameLike(String CompanyName);
}
