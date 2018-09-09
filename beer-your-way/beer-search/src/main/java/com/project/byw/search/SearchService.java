package com.project.byw.search;

import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.metrics.max.InternalMax;
import org.elasticsearch.search.aggregations.metrics.min.InternalMin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.search.aggregations.AggregationBuilders.max;
import static org.elasticsearch.search.aggregations.AggregationBuilders.min;
@Service
public class SearchService {

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    public <T> List<T> searchProductsWithFilters(List<QueryProvider> queryProviders, Class<T> type) {
        NativeSearchQueryBuilder searchQuery = new NativeSearchQueryBuilder();
        queryProviders.forEach(queryProvider -> searchQuery.withFilter(queryProvider.getQuery()));
        return elasticsearchTemplate.queryForList(searchQuery.build(), type);
    }

    public Double getMinValue(String field) {
        String fieldValue = field + "-min";
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery())
                .addAggregation(min(fieldValue).field(field))
                .build();
        Aggregations aggregations = elasticsearchTemplate.query(searchQuery, response -> response.getAggregations());
        return ((InternalMin) aggregations.get(fieldValue)).getValue();
    }

    public Double getMaxValue(String field) {
        String fieldValue = field + "-max";
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery())
                .addAggregation(max(fieldValue).field(field))
                .build();
        Aggregations aggregations = elasticsearchTemplate.query(searchQuery, response -> response.getAggregations());
        return ((InternalMax) aggregations.get(fieldValue)).getValue();
    }
}
