package com.ngfood.consumer.dto;


public class ConsumerRequest {

     Long consumerId;
     String name;
     String gst;
     String address;
     Long owner;
     Long contactPerson;

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

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public Long getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(Long contactPerson) {
        this.contactPerson = contactPerson;
    }
}
