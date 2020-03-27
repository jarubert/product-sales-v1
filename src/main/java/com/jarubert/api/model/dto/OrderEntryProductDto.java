package com.jarubert.api.model.dto;

import com.jarubert.api.model.entity.Product;
import lombok.Data;

@Data
public class OrderEntryProductDto {
    private final Long id;
    private final String name;
    private final String description;

    public OrderEntryProductDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public OrderEntryProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
    }
}
