package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PRODUCTS")
public class Product {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Group groupId;
    private List<Cart> carts = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    public Long getId() { return id; }

    @Column(name = "PRODUCT_NAME")
    @NotNull
    public String getName() { return name; }

    @Column(name = "DESCRIPTION")
    @NotNull
    public String getDescription() { return description; }

    @Column(name = "PRICE")
    @NotNull
    public BigDecimal getPrice() { return price; }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "GROUP_ID")
    public Group getGroupId() { return groupId; }

    @Transient
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    public List<Cart> getCarts() { return carts; }

    public Product(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}

