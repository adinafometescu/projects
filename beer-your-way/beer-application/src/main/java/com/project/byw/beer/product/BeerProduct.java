package com.project.byw.beer.product;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "beer", type = "product")
public class BeerProduct extends Product {

}
