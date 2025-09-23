package com.ngfood.person.controller;

import com.ngfood.person.dto.PersonLookUpDto;
import com.ngfood.person.dto.PersonRequest;
import com.ngfood.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "person")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping(value = "/create")
    public void createPerson(@RequestBody PersonRequest personRequest){
        personService.createPerson(personRequest);
    }

    @GetMapping(value = "/lookup")
    public List<PersonLookUpDto> fetchPersonLookUp(){
        return personService.fetchPersonLookUp();
    }
}
