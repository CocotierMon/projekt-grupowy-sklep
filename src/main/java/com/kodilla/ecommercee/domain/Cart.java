package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "id", nullable = true)
    private Long id;
}

