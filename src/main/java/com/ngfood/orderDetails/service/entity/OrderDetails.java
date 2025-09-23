package com.ngfood.orderDetails.service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="order_details", schema = "ngfood")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name ="order_details_id")
    private Long orderDetailsId;

    @Column(name = "bag_weight")
    private Long bagWeight;

    @Column(name ="bill_due_date")
    private LocalDateTime billDueDate;

    @Column(name = "cash_discount")
    private double cashDiscount;

    @Column(name ="no_of_bags")
    private Long noOfBags;

    @Column(name ="order_date")
    private LocalDate orderDate;

    @Column(name ="rate")
    private Long rate;

    @Column(name ="remarks")
    private String remarks;

    @Column(name ="total_amount")
    private Double totalAmount;

    @Column(name ="total_quantity")
    private Double totalQuantity;

    public Long getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(Long orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public Long getBagWeight() {
        return bagWeight;
    }

    public void setBagWeight(Long bagWeight) {
        this.bagWeight = bagWeight;
    }

    public LocalDateTime getBillDueDate() {
        return billDueDate;
    }

    public void setBillDueDate(LocalDateTime billDueDate) {
        this.billDueDate = billDueDate;
    }


    public Long getNoOfBags() {
        return noOfBags;
    }

    public void setNoOfBags(Long noOfBags) {
        this.noOfBags = noOfBags;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
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

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Double totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public double getCashDiscount() {
        return cashDiscount;
    }

    public void setCashDiscount(double cashDiscount) {
        this.cashDiscount = cashDiscount;
    }
}
