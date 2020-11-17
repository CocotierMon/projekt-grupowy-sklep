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
    private List<Order> orders = new ArrayList<>();

    private List<Cart> carts = new ArrayList<>();
    private int amount;
    private BigDecimal sum;


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

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    public Group getGroupId() { return groupId; }

    @ManyToMany(mappedBy = "products")
    public List<Cart> getCarts() { return carts; }

    @ManyToMany(mappedBy = "products")
    public List<Order> getOrders() { return orders; }

    @Column(name = "AMOUNT")
    public int getAmount() { return amount; }

    @Column(name = "TOTAL_VALUE_OF_PRODUCT")
    public BigDecimal getSum() { return sum; }

    public Product(String name, String description, BigDecimal price, int amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.sum = getSum();
    }

}
