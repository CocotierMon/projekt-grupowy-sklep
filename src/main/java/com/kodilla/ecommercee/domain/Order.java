package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
@Access(AccessType.FIELD)
public class Order {

    private Cart cart;
    private User user;
    private Long id;

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long getId(){
        return id;
    };

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CART_ID")
    private Cart getCart(){
        return cart;
    };

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }
}