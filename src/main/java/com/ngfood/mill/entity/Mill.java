package com.ngfood.mill.entity;

import com.ngfood.brokerage.entity.BrokerageDetails;
import com.ngfood.person.entity.PersonEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(schema = "ngfood")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "mill_id")
    private Long millId;

    @Column(name = "name")
    private String name;

    @Column(name ="create_date")
    public LocalDateTime createDate;

    @Column(name ="update_date")
    private LocalDateTime updateDate;

    @Column(name ="type")
    private String type;

    @Column(name="address")
    private String address;

    @Column(name="gst")
    private String gst;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name ="owner", referencedColumnName = "person_id")
    private PersonEntity owner;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name ="contact_person", referencedColumnName = "person_id")
    private PersonEntity contactPerson;

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

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }
}
