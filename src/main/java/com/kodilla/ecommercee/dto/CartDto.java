package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.User;
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

public class CartDto {
    private Long id;
    private BigDecimal sum;
    private List<ProductDto> productsList = new ArrayList<>();
    private List<OrderDto> orders = new ArrayList<>();
    private User user;
}