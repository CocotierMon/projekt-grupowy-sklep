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

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "carts")
@Access(AccessType.FIELD)
public class Cart {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "id", nullable = true)
    private Long id;

    @Column(name = "sum")
    private BigDecimal sum = new BigDecimal(0);

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "join_cart_product",
            joinColumns = {@JoinColumn(name = "cart_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")})
    @Column(name="products")
    private List<Product> products = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Order.class, mappedBy = "cart")
    private List<Order> orders = new ArrayList<>();
}

