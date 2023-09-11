package com.cgi.newelasticfazzy.util;

import co.elastic.clients.elasticsearch._types.query_dsl.FuzzyQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;

import java.util.function.Supplier;


public class Esutil {
//    public static Supplier<Query> createSupplierQuery(String approximateProductName){
//        Supplier<Query> supplier = ()->Query.of(q->q.fuzzy(createFuzzyQuery(approximateProductName)));
//        return supplier;
//    }
//    public static FuzzyQuery createFuzzyQuery(String approximateProductName){
//        var fuzzyQuery = new FuzzyQuery.Builder();
//        return fuzzyQuery.field("productName").value(approximateProductName).build();
//    }
public static Supplier<Query> createSupplierQuery(String approximateProductName){
    Supplier<Query> supplier = ()->Query.of(q->q.fuzzy(createFuzzyQuery(approximateProductName)));
    return  supplier;
}


    public static FuzzyQuery createFuzzyQuery(String approximateProductName){
        var fuzzyQuery  = new FuzzyQuery.Builder();
        return  fuzzyQuery.field("productName").value(approximateProductName).build();

    }
}
