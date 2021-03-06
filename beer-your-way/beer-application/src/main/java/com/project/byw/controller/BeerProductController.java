package com.project.byw.controller;

import com.project.byw.exception.ProductNotFound;
import com.project.byw.product.BeerProduct;
import com.project.byw.service.BeerFilter;
import com.project.byw.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Controller
public class BeerProductController {

    @Autowired
    BeerService beerService;

    @GetMapping("/beer/{id}")
    public String getPdp(@PathVariable String id, Map<String, Object> model) {
        Optional<BeerProduct> beerProduct = beerService.getBeerWithId(id);
        if (!beerProduct.isPresent()) {
            throw new ProductNotFound();
        }
        model.put("product", beerProduct.get());
        return "beer_product";
    }

    @GetMapping("/search/beer")
    public String getBeerResults(BeerFilter searchForm, Map<String, Object> model) {
        model.put("beerResults", beerService.searchBeers(Collections.singletonList(searchForm.getPriceRange())));
        return "beer_results";
    }
}
