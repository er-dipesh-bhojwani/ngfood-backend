package com.ngfood.mill.mapper;

import com.ngfood.mill.dto.MillDto;
import com.ngfood.mill.dto.MillRequest;
import com.ngfood.mill.entity.Mill;
import com.ngfood.person.helper.PersoMapperHelper;
import com.ngfood.person.mapper.PersonMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { PersonMapper.class, PersoMapperHelper.class })
public interface MillMapper {

     MillDto toDto(Mill millEntity);
     List<MillDto> toDtoList(List<Mill> millEntityList);

     @Mapping(source = "ownerId", target = "owner", qualifiedByName = "mapPerson")
     @Mapping(source = "contactPersonId", target = "contactPerson", qualifiedByName = "mapPerson")
     Mill toEntity(MillRequest millRequest);

}
