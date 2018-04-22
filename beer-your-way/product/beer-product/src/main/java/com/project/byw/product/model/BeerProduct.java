package com.project.byw.product.model;

import com.project.byw.product.Product;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "beer", type = "product")
public class BeerProduct extends Product {

}
