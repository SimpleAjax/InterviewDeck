package com.interviewdeck.controllers;

import com.interviewdeck.dtos.*;
import com.interviewdeck.models.*;
import com.interviewdeck.repository.*;
import com.interviewdeck.services.SignupService;
import com.interviewdeck.services.ValidateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
public class UniversalController {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    SignupService signupService;
    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    DeckRepository deckRepository;

    @Autowired
    UserContentPageRepository userContentPageRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/status")
    public String status() {
        System.out.println("In the /status");
        return "OK";
    }

    @GetMapping("/datainit")
    public String dataInit() {
        Company amazon = companyRepository.save(new Company("amazon"));
        Company google = companyRepository.save(new Company("google"));
        Company rivigo = companyRepository.save(new Company("rivigo"));

        UserContentPage contentPage = userContentPageRepository.save(new UserContentPage());

        User amazonUser = userRepository.save(User.getUser("AmazonFanBoy@gmail.com"));
        User googleUser = userRepository.save(User.getUser("GoogleFanBoy@gmail.com"));
        User rivigoUser = userRepository.save(User.getUser("RivigoFanBoy@gmail.com"));

        deckRepository.save(new Deck(amazonUser, "amazonDeck", amazon, false,
                "interview review for amazon", "amazon deck desc", new ArrayList<>()));

        deckRepository.save(new Deck(googleUser, "googleDeck", google, false,
                "interview review for google", "google deck desc", new ArrayList<>()));

        deckRepository.save(new Deck(rivigoUser, "rivigoDeck", rivigo, true,
                "interview review for rivigo", "rivigo deck desc", new ArrayList<>()));

        return "data created successfully";
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

    @PostMapping("/signup")
    public String signup(@Valid @RequestBody SignUpDTO signUpDTO, BindingResult result){

        if(result.hasErrors()) {
            return "Found errors";
        }
        return signupService.signup(signUpDTO);
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

    @GetMapping("/company/list")
    public List<CompanyDTO> getAllCompanies(){
        Iterable<Company> companyItr = companyRepository.findAll();
        Iterator<Company> compItr = companyItr.iterator();
        List<CompanyDTO> companyDTOs= new ArrayList<>();

        while(compItr.hasNext()){
            companyDTOs.add(Company.createCompanyDTO(compItr.next()));
        }
        return companyDTOs;
    }


    @GetMapping("/deck/{companyId}")
    public List<DeckDTO> getAllDeckOnCriteria(@PathVariable long companyId) {
        List<DeckDTO> deckDTOs = new ArrayList<>();
        Optional<Company> company = companyRepository.findById(companyId);
        System.out.println("company.isPresent() value is: " + company.isPresent());
        if(!company.isPresent()) return deckDTOs;
        System.out.println("company we got is for id: " + companyId + "is : " + company.get());
       List<Deck> decks = deckRepository.getByCompany(company.get());
       for(Deck deck : decks) {
           deckDTOs.add(Deck.createDTO(deck));
       }
       return deckDTOs;
    }



}
