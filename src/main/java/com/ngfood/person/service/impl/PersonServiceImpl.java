package com.ngfood.person.service.impl;

import com.ngfood.person.dto.PersonLookUpDto;
import com.ngfood.person.dto.PersonRequest;
import com.ngfood.person.entity.PersonEntity;
import com.ngfood.person.mapper.PersonMapper;
import com.ngfood.person.repo.PersonRepo;
import com.ngfood.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepo personRepo;

    @Autowired
    PersonMapper personMapper;

    @Override
    public void createPerson( PersonRequest personRequest) {
        PersonEntity person = personMapper.toEntity(personRequest);
        person.setCreateDate(LocalDateTime.now());
        personRepo.save(person);
    }

    @Override
    public List<PersonLookUpDto> fetchPersonLookUp() {

        List<PersonLookUpDto> personDtos = personRepo.findDistinctPersonNames();
        return personDtos;

    }
}
