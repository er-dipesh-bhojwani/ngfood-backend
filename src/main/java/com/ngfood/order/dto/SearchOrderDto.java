package com.ngfood.order.dto;


import com.ngfood.brokerage.dto.Brokerage;
import com.ngfood.brokerage.entity.BrokerageDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SearchOrderDto {

    private Long orderId;
    private Long noOfBags;
    private Long rate;
    private Long bagWeight;
    private Long cashDiscount;
    private Long totalQuantity;
    private Long totalAmount;
    private LocalDateTime orderDate;
    private String remarks;
    private LocalDateTime billDueDate;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getNoOfBags() {
        return noOfBags;
    }

    public void setNoOfBags(Long noOfBags) {
        this.noOfBags = noOfBags;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public Long getBagWeight() {
        return bagWeight;
    }

    public void setBagWeight(Long bagWeight) {
        this.bagWeight = bagWeight;
    }

    public Long getCashDiscount() {
        return cashDiscount;
    }

    public void setCashDiscount(Long cashDiscount) {
        this.cashDiscount = cashDiscount;
    }

    public Long getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Long totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDateTime getBillDueDate() {
        return billDueDate;
    }

    public void setBillDueDate(LocalDateTime billDueDate) {
        this.billDueDate = billDueDate;
    }
}
