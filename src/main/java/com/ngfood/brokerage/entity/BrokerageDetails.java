package com.ngfood.brokerage.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(schema = "ngfood", name = "brokerage_details")
public class BrokerageDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "consumer_brokerage_type")
    private String consumerBrokerageType;

    @Column(name = "mill_brokerage_type")
    private String millBrokerageType;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "orderId")
    private Long orderId;

    @Column(name = "consumer_brokerage")
    private Double consumerBrokerage;

    @Column(name = "mill_brokerage")
    private Double millBrokerage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConsumerBrokerageType() {
        return consumerBrokerageType;
    }

    public void setConsumerBrokerageType(String consumerBrokerageType) {
        this.consumerBrokerageType = consumerBrokerageType;
    }

    public String getMillBrokerageType() {
        return millBrokerageType;
    }

    public void setMillBrokerageType(String millBrokerageType) {
        this.millBrokerageType = millBrokerageType;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getConsumerBrokerage() {
        return consumerBrokerage;
    }

    public void setConsumerBrokerage(Double consumerBrokerage) {
        this.consumerBrokerage = consumerBrokerage;
    }

    public Double getMillBrokerage() {
        return millBrokerage;
    }

    public void setMillBrokerage(Double millBrokerage) {
        this.millBrokerage = millBrokerage;
    }
}
