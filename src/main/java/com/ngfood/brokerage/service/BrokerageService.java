package com.ngfood.brokerage.service;

import com.ngfood.brokerage.dto.SearchBrokerageResponse;
import com.ngfood.brokerage.dto.SearchBrokerageRequest;
import com.ngfood.brokerage.entity.BrokerageDetails;
import com.ngfood.order.OrderRequest;

public interface BrokerageService {

    BrokerageDetails saveBrokerage(OrderRequest orderRequest, Long orderId);
     SearchBrokerageResponse fetchBrokerageByFilters(SearchBrokerageRequest searchBrokerageRequest, String source);
}
