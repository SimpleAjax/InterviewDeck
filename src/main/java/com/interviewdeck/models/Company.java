package com.interviewdeck.models;

import com.interviewdeck.dtos.CompanyDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company extends BaseModel {
    String name;
    public static CompanyDTO createCompanyDTO(Company comp) {
        CompanyDTO dto = new CompanyDTO();
        dto.setId(comp.getId());
        dto.setName(comp.getName());
        return dto;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}
