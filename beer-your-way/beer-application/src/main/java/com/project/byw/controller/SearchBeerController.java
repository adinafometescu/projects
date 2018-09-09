package com.project.byw.controller;

import com.project.byw.service.PriceRange;
import com.project.byw.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchBeerController {

    @Autowired
    BeerService beerService;

    @GetMapping("/beer/price/range")
    public PriceRange getPriceRange() {
        return beerService.getPriceRange();
    }
}
