package com.project.byw.service;

import com.project.byw.beer.product.BeerTaste;

import java.math.BigDecimal;
public class BeerFilter{

    private BigDecimal priceMin;

    private BigDecimal priceMax;

    private BeerTaste taste;

    public BigDecimal getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(BigDecimal priceMin) {
        this.priceMin = priceMin;
    }

    public BigDecimal getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(BigDecimal priceMax) {
        this.priceMax = priceMax;
    }

    public BeerTaste getTaste() {
        return taste;
    }

    public void setTaste(BeerTaste taste) {
        this.taste = taste;
    }
}
