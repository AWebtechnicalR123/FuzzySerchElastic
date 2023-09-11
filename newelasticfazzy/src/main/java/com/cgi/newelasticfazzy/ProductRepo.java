package com.cgi.newelasticfazzy;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepo extends ElasticsearchRepository<Product,String> {
    Iterable<Product> searchByProductName(String productName);
}
