package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {
    private Long id;
    private User user;
    private Order order;
}
