package com.project.byw.service;

import com.project.byw.beer.product.BeerProduct;
import com.project.byw.beer.product.BeerProductRepository;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

import static org.elasticsearch.index.query.QueryBuilders.rangeQuery;

@Service
public class DefaultBeerService implements BeerService {

    @Autowired
    BeerProductRepository beerProductRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public Optional<BeerProduct> getBeerWithId(String id) {
        return beerProductRepository.findById(id);
    }

    @Override
    public List<BeerProduct> searchBeers(BeerFilter beerFilter) {
        RangeQueryBuilder priceRange = rangeQuery("price");
        if (beerFilter.getPriceMin() != null) {
            priceRange.gte(beerFilter.getPriceMin());
        }
        if (beerFilter.getPriceMax() != null) {
            priceRange.lte(beerFilter.getPriceMax());
        }
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withFilter(priceRange)
                .build();
        return elasticsearchTemplate.queryForList(searchQuery, BeerProduct.class);
    }

    @EventListener(ContextRefreshedEvent.class)
    public void addTestUser() {
        BeerProduct beerProduct = new BeerProduct();
        beerProduct.setId("123");
        beerProduct.setBrand("DOO");
        Map<Locale, String> title = new HashMap<>();
        title.put(Locale.ENGLISH, "Product title");
        title.put(new Locale("ro"), "Titlu");
        beerProduct.setTitle(title);

        Map<Locale, String> shortDescription = new HashMap<>();
        shortDescription.put(Locale.ENGLISH, "This is a cool product");
        shortDescription.put(new Locale("ro"), "Acesta este un produs cool");
        beerProduct.setShortDescription(shortDescription);

        beerProduct.setImage("rochefort.jpg");
        beerProduct.setPrice(BigDecimal.TEN);
        beerProductRepository.save(beerProduct);
    }
}
