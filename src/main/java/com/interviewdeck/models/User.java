package com.interviewdeck.models;

import javax.persistence.Entity;

@Entity
public class User extends BaseModel{
    String userId;
    Profile userProfile;
    ContentPage contentPage;
}
