package com.ngfood.order.service.impl;

import com.ngfood.brokerage.entity.BrokerageDetails;
import com.ngfood.brokerage.service.BrokerageService;
import com.ngfood.order.OrderRequest;
import com.ngfood.order.dto.SearchOrderDto;
import com.ngfood.order.entity.Order;
import com.ngfood.order.mapper.OrderMapper;
import com.ngfood.order.repo.OrderRepo;
import com.ngfood.order.service.OrderService;
import com.ngfood.orderDetails.service.OrderDetailsService;
import com.ngfood.orderDetails.service.entity.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    BrokerageService brokerageService;

    @Autowired
    OrderDetailsService orderDetailsService;

    @Override
    public List<SearchOrderDto> fetchAllOrderDetails() {
        List<Order> orderList = orderRepo.findAll();
        List<SearchOrderDto> orderDtoList = orderMapper.toDtoList(orderList);
        System.out.println("Order List :" + orderDtoList);
        return orderDtoList;
    }

    @Override
    @Transactional
    public void createOrder(OrderRequest orderRequest) {
        // Neter in Order Details Table
        OrderDetails orderDetails= orderDetailsService.buildOrderDetails(orderRequest);
        System.out.println("Order Details Id:" + orderDetails);

        // Enter into Brokerage table
        BrokerageDetails brokerageDetails= brokerageService.saveBrokerage(orderRequest, 0L);
        System.out.println("Brokerage Details Id:" + brokerageDetails);

        Order order = new Order();

        order.setMillId(orderRequest.getMillId());
        order.setConsumerId(orderRequest.getConsumerId());
        order.setCreateDate(orderRequest.getOrderDate());
        order.setOrderDetails(orderDetails);
        order.setBrokerageDetails(brokerageDetails);
        orderRepo.save(order);
    }
}
