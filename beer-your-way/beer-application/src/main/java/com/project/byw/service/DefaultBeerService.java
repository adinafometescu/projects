package com.project.byw.service;

import com.project.byw.product.BeerProduct;
import com.project.byw.product.BeerTaste;
import com.project.byw.product.repository.BeerProductRepository;
import com.project.byw.search.QueryProvider;
import com.project.byw.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class DefaultBeerService implements BeerService {

    @Autowired
    private BeerProductRepository beerProductRepository;

    @Autowired
    private SearchService searchService;

    @Override
    public Optional<BeerProduct> getBeerWithId(String id) {
        return beerProductRepository.findById(id);
    }

    @Override
    public List<BeerProduct> searchBeers(List<QueryProvider> queryProviders) {
        return searchService.searchProductsWithFilters(queryProviders, BeerProduct.class);
    }

    @Override
    public PriceRange getPriceRange() {
        PriceRange priceRange = new PriceRange();
        String price = "price";
        priceRange.setPriceMax(BigDecimal.valueOf(searchService.getMaxValue(price)));
        priceRange.setPriceMin(BigDecimal.valueOf(searchService.getMinValue(price)));
        return priceRange;
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
        beerProduct.setTaste(BeerTaste.BALANCED);
        beerProduct.setImage("rochefort.jpg");
        beerProduct.setPrice(BigDecimal.TEN);
        beerProductRepository.save(beerProduct);

        BeerProduct beerProduct2 = new BeerProduct();
        beerProduct2.setId("2233");
        beerProduct2.setBrand("DOO");
        Map<Locale, String> title2 = new HashMap<>();
        title2.put(Locale.ENGLISH, "Product title");
        title2.put(new Locale("ro"), "Titlu");
        beerProduct2.setTitle(title2);

        Map<Locale, String> shortDescription2 = new HashMap<>();
        shortDescription2.put(Locale.ENGLISH, "This is a cool product");
        shortDescription2.put(new Locale("ro"), "Acesta este un produs cool");
        beerProduct2.setShortDescription(shortDescription2);
        beerProduct2.setTaste(BeerTaste.BALANCED);
        beerProduct2.setImage("rochefort.jpg");
        beerProduct2.setPrice(BigDecimal.valueOf(200));
        beerProductRepository.save(beerProduct2);
    }
}
