package com.interviewdeck.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
@MappedSuperclass  // this will tell spring jpa to create these fields in all the tables of derived classes
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class) // way to enable auditing for any class
public class BaseModel {
    @Id // for auditing listener to identify
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id; //UUID

    @Temporal(TemporalType.TIMESTAMP) // defines what type fo date to be stored in db
    @CreatedDate // for auditing listener to identify. so system will fill. client will not fill
    @Column(updatable = false)
    Date createdAt;

    @Temporal(TemporalType.TIMESTAMP) // defines what type fo date to be stored in db
    @LastModifiedDate // for auditing listener to identify
    Date modifiedAt;
    @Override
    public boolean equals(Object obj){
        if(obj!=null && obj.getClass()==getClass()){
            return id==((BaseModel) obj).id;
        }
        return false;
    }
}
