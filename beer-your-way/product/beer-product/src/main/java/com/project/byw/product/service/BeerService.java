package com.project.byw.product.service;

import com.project.byw.product.model.BeerProduct;
import com.project.byw.product.repository.BeerProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

@Service
public class BeerService {

    @Autowired
    BeerProductRepository beerProductRepository;

    public Optional<BeerProduct> getBeerWithId(String id){
        return beerProductRepository.findById(id);
    }

    @EventListener(ContextRefreshedEvent.class)
    public void addTestUser() {
        BeerProduct beerProduct = new BeerProduct();
        beerProduct.setId("123");
        beerProduct.setBrand("DOO");
        Map<Locale,String> title = new HashMap<>();
        title.put(Locale.ENGLISH,"Product title");
        title.put(new Locale("ro"),"Titlu");
        beerProduct.setTitle(title);

        Map<Locale,String> shortDescription = new HashMap<>();
        shortDescription.put(Locale.ENGLISH,"This is a cool product");
        shortDescription.put(new Locale("ro"),"Acesta este un produs cool");
        beerProduct.setShortDescription(shortDescription);

        beerProduct.setImage("rochefort.jpg");
        beerProduct.setPrice(BigDecimal.TEN);
        beerProductRepository.save(beerProduct);
    }
}
