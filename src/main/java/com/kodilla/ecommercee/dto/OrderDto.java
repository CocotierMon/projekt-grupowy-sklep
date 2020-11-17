package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Delivery;
import com.kodilla.ecommercee.domain.Invoice;
import com.kodilla.ecommercee.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderDto {
    private Long id;
    private LocalDate date_of_order;
    private LocalDate date_of_order_acceptance;
    private LocalDate fulfillment;
    private Cart cart;
    private Delivery delivery;
    private Invoice invoice;
    private List<ProductDto> products = new ArrayList<>();
    private BigDecimal sum = new BigDecimal(0);
    private BigDecimal total_sum_of_order = new BigDecimal(0);
    private User user;
}
