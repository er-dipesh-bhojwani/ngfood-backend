package com.ngfood.brokerage.dto;


import java.time.LocalDateTime;


public class SearchBrokerageRequest {

    private  Long millId;
    private  Long consumerId;
    private LocalDateTime orderDate;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;

    public Long getMillId() {
        return millId;
    }

    public void setMillId(Long millId) {
        this.millId = millId;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDateTime getToDate() {
        return toDate;
    }

    public void setToDate(LocalDateTime toDate) {
        this.toDate = toDate;
    }
}
