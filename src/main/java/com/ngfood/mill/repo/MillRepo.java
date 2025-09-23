package com.ngfood.mill.repo;

import com.ngfood.mill.dto.MillNameLookupDto;
import com.ngfood.mill.entity.Mill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MillRepo extends JpaRepository<Mill, Long> {

    @Query(name = "findDistinctMillNames", value = "select distinct new com.ngfood.mill.dto.MillNameLookupDto(m.millId, m.name) from Mill m")
    List<MillNameLookupDto> findDistinctMillNames();

    String findNameByMillId(Long millId);
}
