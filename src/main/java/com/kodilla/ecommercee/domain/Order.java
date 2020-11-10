package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {

    private Long id;
    private Cart cart;
    private List<Product> products;

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
    public Long getId(){return id;};

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CART_ID")
    public Cart getCart() {return cart;}

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "JOIN_ORDER_PRODUCTS",
            joinColumns = {@JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")})
    public List<Product> getProducts() { return products; }

}
