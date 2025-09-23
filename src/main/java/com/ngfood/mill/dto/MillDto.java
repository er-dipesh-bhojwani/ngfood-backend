package com.ngfood.mill.dto;

import com.ngfood.person.dto.PersonRequest;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class MillDto {
    private Long millId;
    private String name;
    private String type;
    private String address;
    private String gst;
    private LocalDateTime createDate;
    PersonRequest owner;
    PersonRequest contactPerson;

    public Long getMillId() {
        return millId;
    }

    public void setMillId(Long millId) {
        this.millId = millId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public PersonRequest getOwner() {
        return owner;
    }

    public void setOwner(PersonRequest owner) {
        this.owner = owner;
    }

    public PersonRequest getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(PersonRequest contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }
}
