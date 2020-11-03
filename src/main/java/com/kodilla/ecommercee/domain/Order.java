package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    private Long id;

}
