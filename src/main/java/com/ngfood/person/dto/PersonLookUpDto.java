package com.ngfood.person.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PersonLookUpDto {

    public PersonLookUpDto( Long personId, String personName) {
        this.personName = personName;
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    private String personName;
    private Long personId;
}
