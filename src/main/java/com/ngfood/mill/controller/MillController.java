package com.ngfood.mill.controller;

import com.ngfood.mill.dto.MillDto;
import com.ngfood.mill.dto.MillNameLookupDto;
import com.ngfood.mill.dto.MillRequest;
import com.ngfood.mill.service.MillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/mill")
public class MillController {

    @Autowired
    MillService millService;

    @GetMapping
    private List<MillDto> fetchMillDetails(){
        List<MillDto> res= millService.fetchMillDetails();
        System.out.println("Final Result :" + res);
        return  res;
    }

    @PostMapping(value = "/create")
    private void createMill(@RequestBody MillRequest millRequest){
        millService.createMill(millRequest);
    }

    @GetMapping("/name/lookup")
    private List<MillNameLookupDto> millNameLookup(){
       return millService.fetchMillNames();
    }
}
