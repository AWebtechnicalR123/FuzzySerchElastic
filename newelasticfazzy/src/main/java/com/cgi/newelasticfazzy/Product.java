package com.cgi.newelasticfazzy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@NoArgsConstructor
@Data
@Document(indexName = "productsnew1er")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Product {
    @Id
    private String productId;

    private String productName;

    private String productBrand;

    private String productImage;

    private String productDescription;

    private double productMRPrice;

    private double productSellPrice;

    private double productDiscount;

    private String shopId;
}
