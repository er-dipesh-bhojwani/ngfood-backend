package com.ngfood.brokerage.repo;

import com.ngfood.brokerage.entity.BrokerageDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrokerageRepo extends JpaRepository<BrokerageDetails, Long> {

}
