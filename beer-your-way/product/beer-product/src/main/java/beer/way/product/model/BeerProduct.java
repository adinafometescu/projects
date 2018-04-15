package beer.way.product.model;

import beer.way.product.Product;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "beer", type = "product")
public class BeerProduct extends Product {

}
