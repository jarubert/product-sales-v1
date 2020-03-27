package com.jarubert.api.model.entity;

import com.jarubert.api.model.dto.ProductDto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jarubert on 2020-03-24.
 */
@Data
@Entity
public class Product {
    private @Id @GeneratedValue Long id;
    private String name;
    private String description;
    private Double price;

    public Product() {
    }

    public Product(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(ProductDto product) {
        product.getId().ifPresent(id -> this.id = id);
        product.getName().ifPresent(name -> this.name = name);
        product.getDescription().ifPresent(description -> this.description = description);
        product.getPrice().ifPresent(price -> this.price = price);
    }
}
