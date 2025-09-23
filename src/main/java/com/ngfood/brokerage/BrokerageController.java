package com.ngfood.brokerage;

import com.ngfood.brokerage.dto.SearchBrokerageResponse;
import com.ngfood.brokerage.dto.SearchBrokerageRequest;
import com.ngfood.brokerage.service.BrokerageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brokerage")
public class BrokerageController {

    @Autowired
    BrokerageService brokerageService;

    @PostMapping
    public SearchBrokerageResponse fetchBrokerageDetails(@RequestBody SearchBrokerageRequest searchBrokerageRequest,
                                                         @RequestParam String  source){
        System.out.println("Brokeage Details :" + searchBrokerageRequest);
        return brokerageService.fetchBrokerageByFilters(searchBrokerageRequest, source);
    }
}
