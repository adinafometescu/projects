package com.project.byw.product;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "beer", type = "product")
public class BeerProduct extends Product {

    private BeerTaste taste;

    public BeerTaste getTaste() {
        return taste;
    }

    public void setTaste(BeerTaste taste) {
        this.taste = taste;
    }
}
