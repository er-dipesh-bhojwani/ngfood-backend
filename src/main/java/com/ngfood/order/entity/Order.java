package com.ngfood.order.entity;

import com.ngfood.brokerage.entity.BrokerageDetails;
import com.ngfood.orderDetails.service.entity.OrderDetails;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(schema = "ngfood", name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name ="order_id")
    private Long orderId;

    @Column(name="mill_id")
    private Long millId;

    @Column(name="consumer_id")
    private Long consumerId;

    @Column(name ="create_date")
    private LocalDate createDate;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JoinColumn(name ="order_details_id", referencedColumnName = "order_details_id")
   private OrderDetails orderDetails;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name ="brokerage_details_id", referencedColumnName = "id")
    private BrokerageDetails brokerageDetails;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    public BrokerageDetails getBrokerageDetails() {
        return brokerageDetails;
    }

    public void setBrokerageDetails(BrokerageDetails brokerageDetails) {
        this.brokerageDetails = brokerageDetails;
    }
}
