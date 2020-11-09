package com.kodilla.ecommercee.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Setter
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {
    private Long id;
    private List<Order> order = new ArrayList<>();
    private Cart cart;

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }
    @OneToMany(targetEntity = Order.class, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Order> getOrder() {
        return order;
    }
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Cart getCart() {
        return cart;
    }
}
