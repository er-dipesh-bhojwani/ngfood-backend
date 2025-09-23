package com.ngfood.orderDetails.service;

import com.ngfood.order.OrderRequest;
import com.ngfood.orderDetails.service.entity.OrderDetails;

public interface OrderDetailsService {

     OrderDetails buildOrderDetails(OrderRequest orderRequest);
}
