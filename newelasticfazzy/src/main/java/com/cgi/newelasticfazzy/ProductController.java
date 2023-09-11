package com.cgi.newelasticfazzy;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;


    @GetMapping("/fuzzySearch/{approximateProductName}")
    List<Product> fuzzySearch(@PathVariable String approximateProductName) throws IOException {
        SearchResponse<Product> searchResponse = productService.fuzzySearch(approximateProductName);
        List<Hit<Product>> hitList = searchResponse.hits().hits();
        System.out.println(hitList);

        List<Product> productList = new ArrayList<>();
        for(Hit<Product> hit :hitList){
            productList.add(hit.source());
        }
        return productList;
    }

    @GetMapping("/get/{productName}")
    public Iterable<Product> findName(@PathVariable String productName){
        return productService.get(productName);
    }

    @GetMapping("/getid/{productId}")
    public Product getProduct(@PathVariable String productId){
        return productService.getId(productId);
    }

    @PostMapping("/post")
    public Product savePr(@RequestBody Product product){
        return productService.saveProduct(product);
    }
}
