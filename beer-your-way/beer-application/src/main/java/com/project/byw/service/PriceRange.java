package com.project.byw.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.byw.search.QueryProvider;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.RangeQueryBuilder;

import java.math.BigDecimal;

import static org.elasticsearch.index.query.QueryBuilders.rangeQuery;

public class PriceRange implements QueryProvider {

    private BigDecimal priceMin;

    private BigDecimal priceMax;

    public PriceRange(BigDecimal priceMin, BigDecimal priceMax) {
        this.priceMin = priceMin;
        this.priceMax = priceMax;
    }

    public PriceRange() {
    }

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

    @Override
    @JsonIgnore
    public QueryBuilder getQuery() {
        RangeQueryBuilder priceRange = rangeQuery("price");
        if (priceMin != null) {
            priceRange.gte(priceMin);
        }
        if (priceMax != null) {
            priceRange.lte(priceMax);
        }
        return priceRange;
    }
}
