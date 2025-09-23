package com.ngfood.mill.service.impl;

import com.ngfood.mill.dto.MillNameLookupDto;
import com.ngfood.mill.dto.MillRequest;
import com.ngfood.mill.entity.Mill;
import com.ngfood.mill.mapper.MillMapper;
import com.ngfood.mill.repo.MillRepo;
import com.ngfood.mill.service.MillService;
import com.ngfood.mill.dto.MillDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MIllServiceImpl implements MillService {

    @Autowired
    MillRepo millRepo;

    @Autowired
    MillMapper millMapper;

    @Override
    public List<MillDto> fetchMillDetails() {
        List<Mill> dbMills = millRepo.findAll();
        System.out.println("List FOr Mill" + dbMills);
        List<MillDto> millDtoList = millMapper.toDtoList(dbMills);
        System.out.println("DTO LIST" + millDtoList);
        return millDtoList;
    }

    @Override
    public void createMill(MillRequest millRequest) {
        Mill mill = millMapper.toEntity(millRequest);
        mill.setCreateDate(LocalDateTime.now());
        millRepo.save(mill);
    }

    @Override
    public List<MillNameLookupDto> fetchMillNames() {
        List<MillNameLookupDto> millNameLookupDtos = millRepo.findDistinctMillNames();
        System.out.println("Mill Name " + millNameLookupDtos);
        return millNameLookupDtos;
    }

    @Override
    public MillDto findByMillId(Long millId) {

        return millRepo.findById(millId).
                map((m) ->  millMapper.toDto(m)).
                orElse(null);
    }

}
