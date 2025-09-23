package com.ngfood.order.dto;

import com.ngfood.brokerage.dto.Brokerage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

public class OrderDto {
    private Long orderId;
    private Date orderDate;
    private Long noOfBags;
    private Long bagWeight;
    private Long totalQuantity;
    private Long totalAmount;
    private Long rate;
    private String remarks;
    private Date billDueDate;
    private Long cashDiscount;
    private Brokerage brokerageDetails;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
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

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getBillDueDate() {
        return billDueDate;
    }

    public void setBillDueDate(Date billDueDate) {
        this.billDueDate = billDueDate;
    }

    public Long getCashDiscount() {
        return cashDiscount;
    }

    public void setCashDiscount(Long cashDiscount) {
        this.cashDiscount = cashDiscount;
    }

    public Brokerage getBrokerageDetails() {
        return brokerageDetails;
    }

    public void setBrokerageDetails(Brokerage brokerageDetails) {
        this.brokerageDetails = brokerageDetails;
    }
}
