package com.cgi.newelasticfazzy;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.cgi.newelasticfazzy.util.Esutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.function.Supplier;

@Service
public class ProductService {
    @Autowired
    private ElasticsearchClient elasticsearchClient;

    @Autowired
    private ProductRepo productRepo;

    public SearchResponse<Product> fuzzySearch(String approximateProductName) throws IOException {
        Supplier<Query> supplier = Esutil.createSupplierQuery(approximateProductName);
        SearchResponse<Product> response = elasticsearchClient.
                search(s->s.index("productsnew1er").query(supplier.get()),Product.class);
        System.out.println("ELastic Search FUzzy query"+supplier.get().toString());
        return response;

    }

    public Iterable<Product> get(String name){
        return productRepo.searchByProductName(name);
    }

    public Product getId(String productId){
        return productRepo.findById(productId).get();
    }

    public Product saveProduct(Product product){
        return productRepo.save(product);
    }
}
