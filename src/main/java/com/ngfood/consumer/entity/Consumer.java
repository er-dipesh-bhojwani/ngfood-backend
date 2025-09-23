package com.ngfood.consumer.entity;

import com.ngfood.person.entity.PersonEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "consumer", schema = "ngfood")
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name ="consumer_id")
    private Long consumerId;

    @Column(name = "name")
    private String name;

    @Column(name ="create_date")
    private LocalDateTime createDate;

    @Column(name ="update_date")
    private LocalDateTime updateDate;

    @Column(name ="gst")
    private String gst;

    @Column(name="address")
    private String address;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name ="owner", referencedColumnName = "person_id")
    private PersonEntity owner;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name ="contact_person", referencedColumnName = "person_id")
    private PersonEntity contactPerson;

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

    public PersonEntity getOwner() {
        return owner;
    }

    public void setOwner(PersonEntity owner) {
        this.owner = owner;
    }

    public PersonEntity getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(PersonEntity contactPerson) {
        this.contactPerson = contactPerson;
    }
}
