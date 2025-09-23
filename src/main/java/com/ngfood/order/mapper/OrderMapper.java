package com.ngfood.order.mapper;

import com.ngfood.order.dto.OrderDBDto;
import com.ngfood.order.dto.OrderDto;
import com.ngfood.order.OrderRequest;
import com.ngfood.order.dto.SearchOrderDto;
import com.ngfood.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

     @Mapping(source ="orderDetails.noOfBags" , target = "noOfBags")
     @Mapping(target= "rate", source = "orderDetails.rate")
     @Mapping(target = "bagWeight", source = "orderDetails.bagWeight")
     @Mapping(target = "cashDiscount", source = "orderDetails.cashDiscount")
     @Mapping(target = "totalQuantity", source = "orderDetails.totalQuantity")
     @Mapping(target = "totalAmount", source = "orderDetails.totalAmount")
     @Mapping(target = "orderDate", source = "orderDetails.orderDate")
     @Mapping(target = "remarks", source = "orderDetails.remarks")
     @Mapping(target = "billDueDate", source = "orderDetails.billDueDate")
     SearchOrderDto toDto(Order order);
     List<SearchOrderDto> toDtoList(List<Order> orderList);
}
