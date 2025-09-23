package com.ngfood.consumer.controller;

import com.ngfood.consumer.dto.ConsumerDto;
import com.ngfood.consumer.dto.ConsumerRequest;
import com.ngfood.consumer.dto.ConsumerNameLookUpDto;
import com.ngfood.consumer.dto.SearchConsumerDto;
import com.ngfood.consumer.entity.Consumer;
import com.ngfood.consumer.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/consumer")
public class ConsumerController {


    @Autowired
    ConsumerService consumerService;


    @GetMapping
    private List<SearchConsumerDto> fetchAllConsumers(){
        List<SearchConsumerDto> result = consumerService.fetchConsumerDetails();
        System.out.println("Result " + result);
        return result;
    }

    @PostMapping(value = "/create")
    private ConsumerRequest createConsumer(@RequestBody ConsumerRequest consumerDto){
        consumerService.createConsumer(consumerDto);
        return  null;
    }

    @GetMapping("/name/lookup")
    private List<ConsumerNameLookUpDto> consumerNameLookUp(){
        return consumerService.fetchConsumerNames();
    }

    @GetMapping("/findById/{consumerId}")
    private ConsumerDto findByConsumerId(@PathVariable Long consumerId){
        return consumerService.findByConsumerId(consumerId);
    }

}
