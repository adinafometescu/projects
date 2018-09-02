package com.project.byw.service;

import java.math.BigDecimal;
public class BeerFilter{

    private BigDecimal priceMin;

    private BigDecimal priceMax;

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
}
