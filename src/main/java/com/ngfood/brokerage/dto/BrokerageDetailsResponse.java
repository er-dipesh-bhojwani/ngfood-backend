package com.ngfood.brokerage.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrokerageDetailsResponse {

//    txDetails : [{
//        orderDate? : string,
//                partyName: string,
//                noOfBags: number,
//                weight: number,
//                quantity: number,
//                rate: number,
//                brokerage: number
//    }]


//    private Long orderId;
//    private Long millId;
//    private String millName;
//    private String consumerName;
//    private Long consumerId;
//    private Double millBrokerage;
//    private Double consumerBrokerage;
//    private LocalDateTime createDate;
//    private Long orderDetailsId;

    private Long orderId;
    private LocalDate orderDate;
    private String partyName;
    private Long noOfBags;
    private Long weight;
    private Double quantity;
    private Long rate;
    private Double millBrokerage;
    private Double consumerBrokerage;
    private Long orderDetailsId;
    private String brokerageRate;
    private Double totalAmount;

    public BrokerageDetailsResponse(LocalDate orderDate, Long noOfBags, Long weight, Double quantity, Long rate, Double millBrokerage, Double consumerBrokerage, Long millId, Long consumerId, Long orderId, Long orderDetailsId,
                                    String brokerageRate, Double totalAmount){
        this.orderDate = orderDate;
        this.noOfBags = noOfBags;
        this.weight = weight;
        this.quantity = quantity;
        this.rate = rate;
        this.millBrokerage = millBrokerage;
        this.consumerBrokerage = consumerBrokerage;
        this.millId = millId;
        this.consumerId = consumerId;
        this.orderId = orderId;
        this.orderDetailsId = orderDetailsId;
        this.brokerageRate = brokerageRate;
        this.totalAmount = totalAmount;
    }

    @JsonIgnore
    private Long millId;

    @JsonIgnore
    private Long consumerId;

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public Long getNoOfBags() {
        return noOfBags;
    }

    public void setNoOfBags(Long noOfBags) {
        this.noOfBags = noOfBags;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public Double getMillBrokerage() {
        return millBrokerage;
    }

    public void setMillBrokerage(Double millBrokerage) {
        this.millBrokerage = millBrokerage;
    }

    public Double getConsumerBrokerage() {
        return consumerBrokerage;
    }

    public void setConsumerBrokerage(Double consumerBrokerage) {
        this.consumerBrokerage = consumerBrokerage;
    }

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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(Long orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public String getBrokerageRate() {
        return brokerageRate;
    }

    public void setBrokerageRate(String brokerageRate) {
        this.brokerageRate = brokerageRate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
