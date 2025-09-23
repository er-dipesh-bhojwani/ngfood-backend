package com.ngfood.person.service;

import com.ngfood.person.dto.PersonLookUpDto;
import com.ngfood.person.dto.PersonRequest;

import java.util.List;

public interface PersonService {

     void createPerson(PersonRequest personRequest);
     List<PersonLookUpDto> fetchPersonLookUp();

}
