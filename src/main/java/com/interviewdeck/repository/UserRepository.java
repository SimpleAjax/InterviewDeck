package com.interviewdeck.repository;

import com.interviewdeck.models.Profile;
import com.interviewdeck.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User save(User user);
    List<User> findByUsername(String username);
}
