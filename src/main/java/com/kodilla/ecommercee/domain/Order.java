package com.kodilla.ecommercee.domain;



import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@Setter
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {

    private Long id;

    private LocalDate date_of_order;
    private LocalDate date_of_order_acceptance;
    private LocalDate fulfillment;
    private Cart cart;
    private Delivery delivery;
    private Invoice invoice;
    private List<Product> products = new ArrayList<>();
    private BigDecimal sum = new BigDecimal(0);
    private BigDecimal total_sum_of_order = new BigDecimal(0);

    private User user;

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "DATE_OF_ORDER")
    public LocalDate getDate_of_order() {
        return date_of_order;
    }
    @Column(name = "DATE_OF_ORDER_ACCEPTANCE")
    public LocalDate getDate_of_order_acceptance() {
        return date_of_order_acceptance;
    }
    @Column(name = "DATE_OF_ORDER_FULFILLMENT")
    public LocalDate getFulfillment() {
        return fulfillment;

    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CART_ID")
    public Cart getCart() {
        return cart;
    }


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "DELIVERY_ID")
    public Delivery getDelivery() {
        return delivery;
    }
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="INVOICE_ID")
    public Invoice getInvoice() {
        return invoice;
    }
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_ORDER_PRODUCT",
            joinColumns = { @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = { @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")}
    )

    public List<Product> getProducts() {
        return products;
    }


    @Column(name="SUM")
    public BigDecimal getSum() {
        return sum;
    }
    @Column(name = "TOTAL_SUM_OF_ORDER")
    public BigDecimal getTotal_sum_of_order() {
        return total_sum_of_order;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }
    public Order(Cart cart, Delivery delivery, User user){
        this.date_of_order = LocalDate.now();
        this.cart = cart;
        this.delivery = delivery;
        this.user = user;
        this.products = cart.getProducts();
        this.sum = cart.getSum();
        this.total_sum_of_order = cart.getSum().add(delivery.getValue());
    }
}

