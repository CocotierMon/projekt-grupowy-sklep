package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {
    private Long id;
    private String username;
    private int status = 1;
    private Long userKey;
    private Cart cart;
    private List<OrderDto> orders = new ArrayList<>();
    private List<InvoiceDto> invoices = new ArrayList<>();
}