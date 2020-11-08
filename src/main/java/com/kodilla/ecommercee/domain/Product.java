package com.kodilla.ecommercee.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Entity
@Table(name = "PRODUCTS")
public class Product {
    private Long id;
    private List<Cart> carts = new ArrayList<>();
    private String name;
    private BigDecimal price;

    public Product (String name, BigDecimal price){
        this.name = name;
        this.price = price;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", nullable = true)
    public Long getId(){
        return id;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    public List<Cart> getCarts() { return carts; }

    @Column(name = "PRICE")
    @NotNull
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

}
