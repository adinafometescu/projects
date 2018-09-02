package com.project.byw.beer.product;

import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;
public interface BeerProductRepository extends ElasticsearchRepository<BeerProduct, String> {

    Page<BeerProduct> findAll();

    Optional<BeerProduct> findById(String id);
}
