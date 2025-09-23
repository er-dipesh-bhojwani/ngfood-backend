package com.ngfood.brokerage.service.impl;

import com.ngfood.brokerage.dto.BrokerageDetailsResponse;
import com.ngfood.brokerage.dto.SearchBrokerageResponse;
import com.ngfood.brokerage.dto.SearchBrokerageRequest;
import com.ngfood.brokerage.entity.BrokerageDetails;
import com.ngfood.brokerage.repo.BrokerageRepo;
import com.ngfood.brokerage.service.BrokerageService;
import com.ngfood.consumer.dto.ConsumerDto;
import com.ngfood.consumer.dto.ConsumerNameLookUpDto;
import com.ngfood.consumer.entity.Consumer;
import com.ngfood.consumer.service.ConsumerService;
import com.ngfood.mill.dto.MillDto;
import com.ngfood.mill.dto.MillNameLookupDto;
import com.ngfood.mill.entity.Mill;
import com.ngfood.mill.service.MillService;
import com.ngfood.order.OrderRequest;
import com.ngfood.order.entity.Order;
import com.ngfood.orderDetails.service.entity.OrderDetails;
import com.ngfood.utils.Utils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BrokerageServiceImpl implements BrokerageService {

    @Autowired
    BrokerageRepo brokerageRepo;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    MillService millService;

    @Autowired
    ConsumerService consumerService;

    private Double calculateBrokerage(String  brokerageType, Long noOfBags, Long rate, Long bagWeight, double cashDiscount) {
        double deriveRate = Double.parseDouble(brokerageType.substring(0, 2));
        if(brokerageType.contains("%"))
            return Utils.totalAmount(noOfBags, bagWeight, rate) * (deriveRate  / 100) ;
        else
            return  Utils.totalWeight(noOfBags, bagWeight) * deriveRate;
    }

    @Override
    public BrokerageDetails saveBrokerage(OrderRequest orderRequest, Long orderId) {
        Double consumerBrokerage = calculateBrokerage(orderRequest.getConsumerBrokerageType(),
                orderRequest.getNoOfBags(), orderRequest.getRate(), orderRequest.getBagWeight(),
                orderRequest.getCashDiscount());

        System.out.println("Consumer Brokerage:" + consumerBrokerage);

        Double millBrokerage = calculateBrokerage(orderRequest.getMillBrokerageType(), orderRequest.getNoOfBags(),
                orderRequest.getRate(), orderRequest.getBagWeight(),
                orderRequest.getCashDiscount());

        System.out.println("Mill Brokerage:" + millBrokerage);

        BrokerageDetails brokerageDetails = new BrokerageDetails();
       // brokerageDetails.setOrderId(orderId);
        brokerageDetails.setMillBrokerage(millBrokerage);
        brokerageDetails.setConsumerBrokerage(consumerBrokerage);
        brokerageDetails.setConsumerBrokerageType(orderRequest.getConsumerBrokerageType());
        brokerageDetails.setMillBrokerageType(orderRequest.getMillBrokerageType());
        brokerageDetails.setCreateDate(LocalDateTime.now());

        return brokerageDetails;
    }

    @Override
    public SearchBrokerageResponse  fetchBrokerageByFilters(SearchBrokerageRequest searchBrokerageRequest, String source) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BrokerageDetailsResponse> criteriaQuery = criteriaBuilder.createQuery(BrokerageDetailsResponse.class);
        Root<Order> root = criteriaQuery.from(Order.class);
        Join<Order, OrderDetails> orderJoin  = root.join("orderDetails");
        Join<Order, BrokerageDetails> brokerageDetailsJoin = root.join("brokerageDetails");
        Join<Order, Consumer> consumerJoin = null;
        Join<Order, Mill> millJoin = null;
        boolean isMill = false;
        List<Predicate> predicates = new ArrayList<>();

        if(source.equals("mill") && searchBrokerageRequest.getMillId() > 0){
            isMill = true;
            predicates.add(criteriaBuilder.equal(root.get("millId") , searchBrokerageRequest.getMillId()));
        }
        else if (source.equals("consumer")  && searchBrokerageRequest.getConsumerId()    > 0){
            predicates.add(criteriaBuilder.equal(root.get("consumerId") , searchBrokerageRequest.getConsumerId()));
        }

        if(searchBrokerageRequest.getFromDate() !=null  && searchBrokerageRequest.getToDate() != null){
            predicates.add(criteriaBuilder.between(brokerageDetailsJoin.get("createDate") , searchBrokerageRequest.getFromDate(),
                    searchBrokerageRequest.getToDate()));
        }
        String brokerageType = isMill ? "millBrokerageType" : "consumerBrokerageType";
        criteriaQuery.select(criteriaBuilder.construct(BrokerageDetailsResponse.class,
                orderJoin.get("orderDate"),
                orderJoin.get("noOfBags"),
                orderJoin.get("bagWeight").alias("weight"),
                orderJoin.get("totalQuantity").alias("quantity"),
                orderJoin.get("rate"),
                brokerageDetailsJoin.get("millBrokerage"),
                brokerageDetailsJoin.get("consumerBrokerage") ,
                root.get("millId"),
                root.get("consumerId"),
                root.get("orderId"),
                orderJoin.get("orderDetailsId"),
                brokerageDetailsJoin.get(brokerageType).alias("brokerageRate"),
                orderJoin.get("totalAmount")
        )).where(predicates);

        Map<Long, String> millNameMap =  millService.fetchMillNames().stream().map(mill -> {
           mill.setName(mill.getName()==null ? "": mill.getName());
        return mill;})
                .collect(Collectors.toMap(MillNameLookupDto::getMillId,
                MillNameLookupDto::getName));

        Map<Long, String> consumerMap = consumerService.fetchConsumerNames().stream().
                map(consumer -> {
                    consumer.setName(consumer.getName()==null ? "": consumer.getName());
                    return consumer;}).
                collect(Collectors.toMap(ConsumerNameLookUpDto::getConsumerId,
                ConsumerNameLookUpDto::getName));

        SearchBrokerageResponse response = new SearchBrokerageResponse();

        if(isMill) {
            MillDto millDto = millService.findByMillId(searchBrokerageRequest.getMillId());
            if(!ObjectUtils.isEmpty(millDto)){
                response.setClientName(millDto.getName());
                response.setAddress(millDto.getAddress());
                response.setMobNumber(millDto.getOwner().getMobNumber());
                response.setGst(millDto.getGst());
            }
        } else{
            ConsumerDto consumerDto = consumerService.findByConsumerId(searchBrokerageRequest.getConsumerId());
            if(!ObjectUtils.isEmpty(consumerDto)) {
                response.setClientName(consumerDto.getName());
                response.setAddress(consumerDto.getAddress());
                response.setMobNumber(consumerDto.getOwner().getMobNumber());
                response.setGst(consumerDto.getGst());
            }
        }

        List<BrokerageDetailsResponse> list = entityManager.createQuery(criteriaQuery).getResultList();

        double totalConsBrokerage = 0.00 ;
        double totalMillBrokerage = 0.00 ;
        double totalBrokerage = 0.00;
        for(BrokerageDetailsResponse searchBrokerageResponse: list) {
            if(searchBrokerageResponse.getMillBrokerage() != null)
             totalMillBrokerage = totalMillBrokerage + searchBrokerageResponse.getMillBrokerage();
            if(searchBrokerageResponse.getConsumerBrokerage() != null) {
                totalConsBrokerage = totalConsBrokerage + searchBrokerageResponse.getConsumerBrokerage();
            }
            searchBrokerageResponse.setPartyName(!isMill ? millNameMap.get(searchBrokerageResponse.getMillId()) :
                            consumerMap.get(searchBrokerageResponse.getConsumerId())
            );

            totalBrokerage = totalConsBrokerage + totalMillBrokerage;
        }
        response.setBrokerageDetailsResponse(list);
        response.setBrokeageAmount(isMill ? new BigDecimal(totalMillBrokerage).setScale(3, RoundingMode.HALF_UP) :
                new BigDecimal(totalConsBrokerage).setScale(3, RoundingMode.HALF_UP)
        );
        response.setTotalConsumerAmount(new BigDecimal(totalConsBrokerage).setScale(3, RoundingMode.HALF_UP));
        response.setTotalMillAmount(new BigDecimal(totalMillBrokerage).setScale(3, RoundingMode.HALF_UP));
        response.setToalBrokerage(new BigDecimal(totalBrokerage).setScale(3, RoundingMode.HALF_UP));
        if(response.getBrokerageDetailsResponse()!=null && !response.getBrokerageDetailsResponse().isEmpty())
            response.setBrokerageRate(response.getBrokerageDetailsResponse().getFirst().getBrokerageRate());


        System.out.println("Result :" + list);
        return response;
    }
}
