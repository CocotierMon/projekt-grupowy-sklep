package com.kodilla.ecommercee.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Setter
@Entity
@Table(name = "ORDERS")
public class Order {

    public Cart cart;
    public User user;
    private Long id;

    public Order(Cart cart, User user) {
        this.cart = cart;
        this.user = user;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CART_ID")
    public Cart getCart() {
        return cart;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }
}