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
    @ManyToOne
    Company company;

    @Column(name = "jobRole")
    String jobRole;

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
                ", company='" + company + '\'' +
                ", jobRole='" + jobRole + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", interviewGiven=" + interviewGiven +
                ", mockInterviewsTaken=" + mockInterviewsTaken +
                ", reputationPoints=" + reputationPoints +
                '}';
    }

    public static Profile convertProfileDTO(ProfileCreationDTO dto) {
        Profile profile = new Profile();
        profile.setInterviewGiven(dto.getInterviewGiven());
        profile.setMockInterviewsTaken(dto.getMockInterviewsTaken());
        profile.setReputationPoints(dto.getReputationPoints());
        profile.setUserName(dto.getUserName());
        return profile;
    }

}
