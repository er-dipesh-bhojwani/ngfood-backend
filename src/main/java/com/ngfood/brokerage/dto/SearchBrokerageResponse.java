package com.ngfood.brokerage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

//consumer name
//mill name
//order date
//mill broker
//consumer broler
//total brokerage
//order details
// Total brokerage

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchBrokerageResponse {

    private List<BrokerageDetailsResponse> brokerageDetailsResponse;
    private String clientName;
    private String gst;
    private String address;
    private String mobNumber;
    private Date from;
    private  Date to;
    private BigDecimal brokeageAmount;
    private BigDecimal totalConsumerAmount;
    private BigDecimal totalMillAmount;
    private BigDecimal toalBrokerage;
    private String brokerageRate;

    public List<BrokerageDetailsResponse> getBrokerageDetailsResponse() {
        return brokerageDetailsResponse;
    }

    public void setBrokerageDetailsResponse(List<BrokerageDetailsResponse> brokerageDetailsResponse) {
        this.brokerageDetailsResponse = brokerageDetailsResponse;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
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

    public String getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(String mobNumber) {
        this.mobNumber = mobNumber;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public String getBrokerageRate() {
        return brokerageRate;
    }

    public void setBrokerageRate(String brokerageRate) {
        this.brokerageRate = brokerageRate;
    }

    public BigDecimal getTotalConsumerAmount() {
        return totalConsumerAmount;
    }

    public void setTotalConsumerAmount(BigDecimal totalConsumerAmount) {
        this.totalConsumerAmount = totalConsumerAmount;
    }

    public BigDecimal getTotalMillAmount() {
        return totalMillAmount;
    }

    public void setTotalMillAmount(BigDecimal totalMillAmount) {
        this.totalMillAmount = totalMillAmount;
    }

    public BigDecimal getToalBrokerage() {
        return toalBrokerage;
    }

    public void setToalBrokerage(BigDecimal toalBrokerage) {
        this.toalBrokerage = toalBrokerage;
    }

    public BigDecimal getBrokeageAmount() {
        return brokeageAmount;
    }

    public void setBrokeageAmount(BigDecimal brokeageAmount) {
        this.brokeageAmount = brokeageAmount;
    }
}




