package com.ngfood.orderDetails.service.repo;

import com.ngfood.order.entity.Order;
import com.ngfood.orderDetails.service.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Long> {
}
