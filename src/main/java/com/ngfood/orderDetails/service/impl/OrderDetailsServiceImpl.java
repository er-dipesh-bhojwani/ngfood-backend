package com.ngfood.orderDetails.service.impl;

import com.ngfood.order.OrderRequest;
import com.ngfood.orderDetails.service.OrderDetailsService;
import com.ngfood.orderDetails.service.entity.OrderDetails;
import com.ngfood.orderDetails.service.repo.OrderDetailsRepo;
import com.ngfood.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;



@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    OrderDetailsRepo orderDetailsRepo;

    @Override
    public OrderDetails buildOrderDetails(OrderRequest orderRequest) {
        Utils utils = new Utils();
        Long noOfBags = orderRequest.getNoOfBags();
        Long bagWeight = orderRequest.getBagWeight();
        Long rate = orderRequest.getRate();

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setBagWeight(bagWeight);
        orderDetails.setBillDueDate(null);
        orderDetails.setCashDiscount(orderRequest.getCashDiscount());
        orderDetails.setNoOfBags(noOfBags);
        orderDetails.setOrderDate(orderRequest.getOrderDate());
        orderDetails.setRate(rate);
        orderDetails.setRemarks(null);
        orderDetails.setTotalAmount(Utils.totalAmount(noOfBags, bagWeight, rate));
        orderDetails.setTotalQuantity(Utils.totalWeight(noOfBags, bagWeight));

        return  orderDetails;

    }

}
