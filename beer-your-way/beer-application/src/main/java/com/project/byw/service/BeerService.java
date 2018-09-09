package com.project.byw.service;


import com.project.byw.product.BeerProduct;
import com.project.byw.search.QueryProvider;

import java.util.List;
import java.util.Optional;

public interface BeerService {
    Optional<BeerProduct> getBeerWithId(String id);

    List<BeerProduct> searchBeers(List<QueryProvider> queryProviders);

    PriceRange getPriceRange();
}
