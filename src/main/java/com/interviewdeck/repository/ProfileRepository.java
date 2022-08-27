package com.interviewdeck.repository;

import com.interviewdeck.models.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {
    Profile save(Profile profile);
}
