package com.interviewdeck.models;

import com.interviewdeck.dtos.ProfileCreationDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UserProfile")
public class Profile extends BaseModel {
    @OneToOne
    User user;
    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "company")
    String company;

    @Column(name = "role")
    String role;

    @Column(name = "profile_pic")
    String picUrl;

    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "interviews_given")
    int interviewGiven;

    @Column(name = "mock_interviews_taken")
    int mockInterviewsTaken;

    @Column(name = "reputation_points")
    int reputationPoints;

    @Override
    public String toString() {
        return "Profile{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", role='" + role + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", interviewGiven=" + interviewGiven +
                ", mockInterviewsTaken=" + mockInterviewsTaken +
                ", reputationPoints=" + reputationPoints +
                '}';
    }

    public static Profile createProfile(ProfileCreationDTO dto) {
        Profile profile = new Profile();
        profile.setInterviewGiven(dto.getInterviewGiven());
        profile.setMockInterviewsTaken(dto.getMockInterviewsTaken());
        profile.setFirstName(dto.getFirstName());
        profile.setLastName(dto.getLastName());
        profile.setReputationPoints(dto.getReputationPoints());
        profile.setUserName(dto.getUserName());
        return profile;
    }

}
