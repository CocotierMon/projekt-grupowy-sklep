package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PRODUCTS")
public class Product {

    private Long id;
    public Group groupId;
    private Order orderId;
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
    @JoinColumn(name = "groupId")
    public Group getGroupId() { return groupId; }
    public void setGroupId(Group groupId) { this.groupId = groupId; }

    @ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "order_id")
    public Order getOrderId() { return orderId;}
    public void setOrderId(Order orderId) { this.orderId = orderId;}

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    public List<Cart> getCarts() {
        return carts;
    }
    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public Product(Long id, String name, String description, double price, Group groupId ){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.groupId = groupId;
    }
}
