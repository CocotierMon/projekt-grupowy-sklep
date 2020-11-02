package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ORDERS")
public class Order {

    private Delivery delivery;
    private Cart cart;
    private List<Product> products;

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "date_of_order")
    private LocalDate date_of_order;

    @Column(name = "date_of_order_acceptance")
    private LocalDate date_of_order_acceptance;

    @Column(name = "date_of_order_fulfillment")
    private LocalDate fulfillment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartId")
    public Cart getCart() { return cart; }
    public void setCart(Cart cart) { this.cart = cart; }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "delivery_id")
    public Delivery getDelivery() { return delivery; }
    public void setDelivery(Delivery delivery) { this.delivery = delivery; }

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "orderId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }

    public Order(Cart cart) {
        this.date_of_order = LocalDate.now();
        this.cart = cart;
        this.products = new ArrayList<>();
    }
}