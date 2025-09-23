package com.ngfood.consumer.service;

import com.ngfood.consumer.dto.ConsumerDto;
import com.ngfood.consumer.dto.ConsumerRequest;
import com.ngfood.consumer.dto.ConsumerNameLookUpDto;
import com.ngfood.consumer.dto.SearchConsumerDto;

import java.util.List;

public interface ConsumerService {

    List<SearchConsumerDto> fetchConsumerDetails();

    void createConsumer(ConsumerRequest consumerDto);

    List<ConsumerNameLookUpDto> fetchConsumerNames();

    ConsumerDto findByConsumerId(Long consumerId);
}
