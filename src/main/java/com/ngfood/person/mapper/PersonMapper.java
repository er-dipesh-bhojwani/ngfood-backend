package com.ngfood.person.mapper;

import com.ngfood.person.dto.PersonRequest;
import com.ngfood.person.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonRequest toDto(PersonEntity order);
    List<PersonRequest> toDtoList(List<PersonEntity> orderList);
    PersonEntity toEntity(PersonRequest personRequest);
}
