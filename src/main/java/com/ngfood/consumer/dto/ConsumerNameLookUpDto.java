package com.ngfood.consumer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumerNameLookUpDto {

    private Long consumerId;
    private String name;
}
