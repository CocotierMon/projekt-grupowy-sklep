package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class Product {

    private Long id;
    private List<Cart> carts = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "id", unique = true, nullable = false)
    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "price_nett")
    private double priceNett;
    @Column(name = "vat_rate")
    private int vatRate;
    @Column(name = "price")
    @NotNull
    private double price;
    @Column(name = "stock_quantity")
    private int stockQuantity;
    @Column(name = "description")
    @NotNull
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group")
    private Group group;

    @ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "order_id")
    private Order orderId;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}
