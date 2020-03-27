package com.jarubert.api.model.dto;

import com.jarubert.api.model.entity.OrderEntry;
import lombok.Data;

import java.util.Optional;

/**
 * Created by jarubert on 2020-03-24.
 */
@Data
public class OrderEntryDto {
    private Integer sequence;
    private OrderEntryProductDto product;
    private Integer quantity;
    private Double basePrice;
    private Double totalPrice;

    public OrderEntryDto() {
    }

    public OrderEntryDto(OrderEntry orderEntry) {
        this.sequence = orderEntry.getSequence();
        this.product = new OrderEntryProductDto(orderEntry.getProduct());
        this.quantity = orderEntry.getQuantity();
        this.basePrice = orderEntry.getBasePrice();
        this.totalPrice = this.quantity * this.basePrice;
    }
}
