package com.project.byw.product.repository;

import com.project.byw.product.model.BeerProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BeerProductRepository extends ElasticsearchRepository<BeerProduct, String> {

    Page<BeerProduct> findAll();

}
