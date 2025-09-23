package com.ngfood.brokerage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brokerage {

    private Long id;
    private String consumerBrokerageType;
    private LocalDateTime createDate;
    private String millBrokerageType;
    private Long orderId;
    private Long millBrokerage;
    private Long consumerBrokerage;
}
