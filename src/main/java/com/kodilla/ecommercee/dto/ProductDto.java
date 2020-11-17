package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Group groupId;
    private Order order;
    private Cart cart;
    private int amount;
    private BigDecimal sum;
}