package com.interviewdeck.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class JobRole extends BaseModel{
    String role;
}
