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

    private User user;
    private Long id;
    private LocalDate fulfillment;
    private LocalDate date_of_order_acceptance;
    private LocalDate date_of_order;
    private Delivery delivery;
    private Cart cart;
    private List<Product> productList = new ArrayList<>();
    private Invoices invoice;

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "id")
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @Column(name = "date_of_order")
    public LocalDate getDate_of_order() { return date_of_order; }
    public void setDate_of_order(LocalDate date_of_order) { this.date_of_order = date_of_order; }

    @Column(name = "date_of_order_acceptance")
    public LocalDate getDate_of_order_acceptance() { return date_of_order_acceptance; }
    public void setDate_of_order_acceptance(LocalDate date_of_order_acceptance) { this.date_of_order_acceptance = date_of_order_acceptance; }

    @Column(name = "date_of_order_fulfillment")
    public LocalDate getFulfillment() { return fulfillment; }
    public void setFulfillment(LocalDate fulfillment) { this.fulfillment = fulfillment; }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    public Cart getCart() { return cart; }
    public void setCart(Cart cart) { this.cart = cart; }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "delivery_id")
    public Delivery getDelivery() { return delivery; }
    public void setDelivery(Delivery delivery) { this.delivery = delivery; }

    @OneToOne
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "join_products_fromCarts",
            joinColumns = {@JoinColumn(name = "carts_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "products_id", referencedColumnName = "id")})
    public List<Product> getProductList() { return cart.getProducts(); }
    public void setProductList(List<Product> productList) { this.productList = productList; }

    @Transient
    @OneToOne
    public Invoices getInvoice() { return invoice; }
    public void setInvoice(Invoices invoices) { this.invoice = invoice; }

    public Order(LocalDate date_of_order, Delivery delivery, Cart cart, List<Product> productList, User user) {
        this.date_of_order = date_of_order;
        this.delivery = delivery;
        this.cart = cart;
        this.productList = cart.getProducts();
        this.user = user;
    }

}