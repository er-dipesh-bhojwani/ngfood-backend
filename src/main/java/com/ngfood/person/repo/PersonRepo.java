package com.ngfood.person.repo;

import com.ngfood.person.dto.PersonLookUpDto;
import com.ngfood.person.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<PersonEntity, Long> {

    @Query(name = "findDistinctPersonNames", value = "select distinct new com.ngfood.person.dto.PersonLookUpDto(p.personId, p.personName) from PersonEntity p")
    List<PersonLookUpDto> findDistinctPersonNames();


}
