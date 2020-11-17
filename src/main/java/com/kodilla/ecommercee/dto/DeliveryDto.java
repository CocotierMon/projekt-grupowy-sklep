package com.kodilla.ecommercee.dto;

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

public class DeliveryDto {
    private Long id;
    private BigDecimal value;
    private Order order;
}
