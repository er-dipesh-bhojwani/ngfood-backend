package com.ngfood.order.controller;

import com.ngfood.order.dto.OrderDto;
import com.ngfood.order.OrderRequest;
import com.ngfood.order.dto.SearchOrderDto;
import com.ngfood.order.service.OrderService;
import io.micrometer.core.instrument.search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    private List<SearchOrderDto> fetchAllOrderDetails(){
        return orderService.fetchAllOrderDetails();
    }

    @PostMapping(value = "create")
    private void createOrder(@RequestBody OrderRequest orderRequest){
        orderService.createOrder(orderRequest);

    }
}
