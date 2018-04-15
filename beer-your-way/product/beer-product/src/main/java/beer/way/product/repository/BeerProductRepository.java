package beer.way.product.repository;

import beer.way.product.model.BeerProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BeerProductRepository extends ElasticsearchRepository<BeerProduct, String> {

    Page<BeerProduct> findAll();

}
