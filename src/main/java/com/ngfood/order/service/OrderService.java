package com.ngfood.order.service;

import com.ngfood.order.dto.OrderDto;
import com.ngfood.order.OrderRequest;
import com.ngfood.order.dto.SearchOrderDto;

import java.util.List;

public interface OrderService {
     List<SearchOrderDto> fetchAllOrderDetails();

     void createOrder(OrderRequest orderRequest);
}
