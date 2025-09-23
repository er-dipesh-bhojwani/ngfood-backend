package com.ngfood.person.helper;

import com.ngfood.person.entity.PersonEntity;
import com.ngfood.person.repo.PersonRepo;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersoMapperHelper {

    @Autowired
    PersonRepo personRepo;

    @Named("mapPerson")
    public PersonEntity mapPerson(Long personId){
        if(personId == null) return  null;
        return personRepo.findById(personId).
                orElseThrow(() -> new RuntimeException("No Person Foujnd with person id:" + personId));
    }

}
