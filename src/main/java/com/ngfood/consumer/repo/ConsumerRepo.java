package com.ngfood.consumer.repo;

import com.ngfood.consumer.dto.ConsumerNameLookUpDto;
import com.ngfood.consumer.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumerRepo extends JpaRepository<Consumer, Long> {

    @Query(name = "findDistinctConsumerNames", value = "select distinct new com.ngfood.consumer.dto.ConsumerNameLookUpDto (c.consumerId, c.name) from Consumer c")
    List<ConsumerNameLookUpDto> findDistinctConsumerNames();

    String findMillIdAndNameByConsumerId(Long consumerId);
}
