package com.ngfood.consumer.service.impl;

import com.ngfood.consumer.dto.ConsumerDto;
import com.ngfood.consumer.dto.ConsumerNameLookUpDto;
import com.ngfood.consumer.dto.ConsumerRequest;
import com.ngfood.consumer.mapper.ConsumerMapper;
import com.ngfood.consumer.dto.SearchConsumerDto;
import com.ngfood.consumer.entity.Consumer;
import com.ngfood.consumer.repo.ConsumerRepo;
import com.ngfood.consumer.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    ConsumerRepo consumerRepo;

    @Autowired
    ConsumerMapper customMapper;


    @Override
    public List<SearchConsumerDto> fetchConsumerDetails() {
        List<Consumer> list =  consumerRepo.findAll();
        List<SearchConsumerDto> consumerDtoList = customMapper.toListDto(list);
        System.out.println("List :" + consumerDtoList);
        return  consumerDtoList;
    }

    @Override
    public void createConsumer( ConsumerRequest consumerDto) {
        Consumer consumer = customMapper.toEntity(consumerDto);
        System.out.println("Entity :" + consumer);
        consumer.setCreateDate(LocalDateTime.now());
        consumerRepo.save(consumer);
    }

    @Override
    public List<ConsumerNameLookUpDto> fetchConsumerNames() {
        List<ConsumerNameLookUpDto> consumerNameLookupDtos = consumerRepo.findDistinctConsumerNames();
        System.out.println("Mill Name " + consumerNameLookupDtos);
        return consumerNameLookupDtos;
    }

    @Override
    public ConsumerDto findByConsumerId(Long consumerId) {
        return  consumerRepo.findById(consumerId).map(
                (c) -> customMapper.toConsumerDto(c)).orElse(null);
    }
}
