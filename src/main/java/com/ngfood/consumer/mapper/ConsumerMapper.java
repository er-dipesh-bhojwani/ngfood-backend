package com.ngfood.consumer.mapper;

import com.ngfood.consumer.dto.ConsumerDto;
import com.ngfood.consumer.dto.ConsumerRequest;
import com.ngfood.consumer.dto.SearchConsumerDto;
import com.ngfood.consumer.entity.Consumer;
import com.ngfood.person.helper.PersoMapperHelper;
import com.ngfood.person.mapper.PersonMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { PersonMapper.class, PersoMapperHelper.class })
public interface ConsumerMapper {

     SearchConsumerDto toDto(Consumer consumer);

     List<SearchConsumerDto> toListDto(List<Consumer> consumers);

     @Mapping(source = "owner", target = "owner", qualifiedByName = "mapPerson")
     @Mapping(source = "contactPerson", target = "contactPerson", qualifiedByName = "mapPerson")
     Consumer toEntity(ConsumerRequest consumer);

     ConsumerDto toConsumerDto(Consumer consumer);



}
