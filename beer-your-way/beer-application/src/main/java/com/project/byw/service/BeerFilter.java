package com.project.byw.service;

import com.project.byw.product.BeerTaste;

import java.math.BigDecimal;

public class BeerFilter {

    private PriceRange priceRange = new PriceRange();

    private BeerTaste taste;

    public BeerTaste getTaste() {
        return taste;
    }

    public void setTaste(BeerTaste taste) {
        this.taste = taste;
    }

    public PriceRange getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(PriceRange priceRange) {
        this.priceRange = priceRange;
    }

    public void setPriceMin(BigDecimal priceMin) {
        this.priceRange.setPriceMin(priceMin);
    }

    public void setPriceMax(BigDecimal priceMax) {
        this.priceRange.setPriceMax(priceMax);
    }


}
