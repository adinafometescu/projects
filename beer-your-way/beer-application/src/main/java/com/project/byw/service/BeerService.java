package com.project.byw.service;

import com.project.byw.beer.product.BeerProduct;

import java.util.List;
import java.util.Optional;

public interface BeerService {
    Optional<BeerProduct> getBeerWithId(String id);

    List<BeerProduct> searchBeers(BeerFilter beerFilter);
}
