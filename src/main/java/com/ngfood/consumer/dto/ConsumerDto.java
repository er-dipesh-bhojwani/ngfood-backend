package com.ngfood.consumer.dto;

import com.ngfood.person.dto.PersonRequest;

import java.time.LocalDateTime;

public class ConsumerDto {

    private Long consumerId;
    private String name;
    private String address;
    private String gst;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    PersonRequest owner;
    PersonRequest contactPerson;

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
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
}
