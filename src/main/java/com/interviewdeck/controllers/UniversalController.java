package com.interviewdeck.controllers;

import com.interviewdeck.dtos.LoginDTO;
import com.interviewdeck.dtos.ProfileCreationDTO;
import com.interviewdeck.models.Profile;
import com.interviewdeck.repository.ProfileRepository;
import com.interviewdeck.services.ValidateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class UniversalController {

    @Autowired
    ProfileRepository profileRepository;

    @GetMapping("/status")
    public String status() {
        System.out.println("In the /status");
        return "OK";
    }

    @GetMapping("/error")
    public String error() {
        System.out.println("In the /error");
        return "error";
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginDTO loginDTO, BindingResult result) {
        if(result.hasErrors()) {
            return "Found errors";
        }
        if(ValidateUser.isValidUser(loginDTO)) return "LOGGED IN";
        return "INVALID_USER / FAILED";
    }

    @PostMapping("/profile/new")
    public String createProfile(@RequestBody @Valid ProfileCreationDTO profileCreationDTO) {
        Profile profile = Profile.createProfile(profileCreationDTO);
        System.out.println("profile saved:\n" + profileRepository.save(profile).toString());
        return "Profile created successfully for user: " + profileCreationDTO.getUserName();
    }

    @GetMapping("/profile")
    public List<Profile> getAllProfile() {
        Iterable<Profile> iterable = profileRepository.findAll();
        Iterator<Profile> profileIterator = iterable.iterator();
        List<Profile> profiles = new ArrayList<>();
        while(profileIterator.hasNext()) {
            profiles.add(profileIterator.next());
        }
        return profiles;
    }

}
