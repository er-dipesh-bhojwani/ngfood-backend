package com.ngfood.order.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDBDto {

    private Long millId;
    private Long consumerId;
    private LocalDateTime createDate;
    private Double brokerageId;
    private Double orderDetailsId;
}
