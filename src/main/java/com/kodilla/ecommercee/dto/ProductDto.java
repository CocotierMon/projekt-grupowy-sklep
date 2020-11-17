package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.Group;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    private List<OrderDto> orders = new ArrayList<>();
    private List<CartDto> carts = new ArrayList<>();
    private int amount;
    private BigDecimal sum;
}