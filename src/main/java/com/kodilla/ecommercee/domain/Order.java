package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ORDERS")
public class Order {

    private User user;
    private Long id;
    private LocalDate fulfillment;
    private LocalDate date_of_order_acceptance;
    private LocalDate date_of_order;
    private Delivery delivery;
    private Cart cart;
    private List<Product> productList = new ArrayList<>();
    private Invoices invoice;
    private BigDecimal total_sum_of_order;
    private BigDecimal sum;

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID")
    public Long getId() { return id; }

    @Column(name = "DATE_OF_ORDER")
    public LocalDate getDate_of_order() { return date_of_order; }

    @Column(name = "DATE_OF_ORDER_ACCEPTANCE")
    public LocalDate getDate_of_order_acceptance() { return date_of_order_acceptance; }

    @Column(name = "DATE_OF_ORDER_FULFILLMENT")
    public LocalDate getFulfillment() { return fulfillment; }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CART_ID")
    public Cart getCart() { return cart; }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "DELIVERY_ID")
    public Delivery getDelivery() { return delivery; }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    public User getUser() { return user; }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "JOIN_PRODUCTS_FROM_CARTS",
            joinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCTS_ID", referencedColumnName = "ID")})
    public List<Product> getProductList() { return productList; }

    @Transient
    public Invoices getInvoice() { return invoice; }

    @Column(name = "TOTAL_SUM_OF_ORDER")
    public BigDecimal getTotal_sum_of_order() { return total_sum_of_order; }

    @Column(name = "SUM")
    public BigDecimal getSum() { return sum; }

    public Order(Cart cart, Delivery delivery, User user) {
        this.date_of_order = LocalDate.now();
        this.cart = cart;
        this.productList = cart.getProducts();
        this.sum = cart.getSum();
        this.total_sum_of_order = cart.getSum().add(delivery.getValue());
        this.user = user;
    }

}