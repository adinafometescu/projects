package beer.way.product.service;

import beer.way.product.model.BeerProduct;
import beer.way.product.repository.BeerProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
        beerProduct.setPrice(BigDecimal.TEN);
        beerProductRepository.save(beerProduct);
    }
}
