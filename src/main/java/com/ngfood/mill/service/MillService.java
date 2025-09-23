package com.ngfood.mill.service;

import com.ngfood.mill.dto.MillDto;
import com.ngfood.mill.dto.MillNameLookupDto;
import com.ngfood.mill.dto.MillRequest;

import java.util.List;

public interface MillService {

    List<MillDto> fetchMillDetails();

    void createMill(MillRequest millRequest);

    List<MillNameLookupDto> fetchMillNames();

    MillDto findByMillId(Long millId);
}
