package com.ngfood.order;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {

    private Long consumerId;
    private Long millId;
    private Long noOfBags;
    private Long bagWeight;
    private LocalDateTime createDate;
    private String variety;
    private String brandName;
    private Long rate;
    private LocalDate orderDate;
    private double cashDiscount;
    private String consumerBrokerageType;
    private String millBrokerageType;

    public double getCashDiscount() {
        return cashDiscount;
    }

    public void setCashDiscount(double cashDiscount) {
        this.cashDiscount = cashDiscount;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public Long getMillId() {
        return millId;
    }

    public void setMillId(Long millId) {
        this.millId = millId;
    }

    public Long getNoOfBags() {
        return noOfBags;
    }

    public void setNoOfBags(Long noOfBags) {
        this.noOfBags = noOfBags;
    }

    public Long getBagWeight() {
        return bagWeight;
    }

    public void setBagWeight(Long bagWeight) {
        this.bagWeight = bagWeight;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
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

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}


