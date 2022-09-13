package com.interviewdeck.repositories;

import com.interviewdeck.models.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {
    Profile save(Profile profile);
}
