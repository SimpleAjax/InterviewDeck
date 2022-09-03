package com.interviewdeck.repository;

import com.interviewdeck.models.Profile;
import com.interviewdeck.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Profile, Integer> {
    User save(User user);
}
