package com.kodilla.ecommercee.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Setter
@NoArgsConstructor
@Entity
@Table(name = "CARTS")
public class Cart {

    private Long id;
    private BigDecimal sum = new BigDecimal(0);
    private List<Product> products = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private User user;

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", nullable = true)
    public Long getId() {
        return id;
    }
    @Column(name = "SUM")
    public BigDecimal getSum() {
        return sum;
    }
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "JOIN_CART_PRODUCT",
            joinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")})
    public List<Product> getProducts() {
        return products;
    }
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Order.class, mappedBy = "cart")
    public List<Order> getOrders() {
        return orders;
    }
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public User getUser() {
        return user;
    }
}

