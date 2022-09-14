package com.interviewdeck.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileCreationDTO {
    private String userName;
    int interviewGiven;
    int mockInterviewsTaken;
    int reputationPoints;

    @Override
    public String toString() {
        return "ProfileCreationDTO{" +
                "userName='" + userName + '\'' +
                ", interviewGiven=" + interviewGiven +
                ", mockInterviewsTaken=" + mockInterviewsTaken +
                ", reputationPoints=" + reputationPoints +
                '}';
    }
}
