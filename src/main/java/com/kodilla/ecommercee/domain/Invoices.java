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
@Entity(name = "INVOICES")
public class Invoices {

    private Long id;
    private List<Product> productList = new ArrayList<>();
    private LocalDate order;
    private double delivery;
    private Cart cart;
    private double sum;
    private User user;

    @Column(name = "date")
    public LocalDate getOrder() { return order; }
    public void setOrder(LocalDate order) { this.order = order; }

    @Column(name = "deliveries")
    public double getDelivery() { return delivery; }
    public void setDelivery(double delivery) { this.delivery = delivery; }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "id")
    public Long getId(){ return id; }
    public void setId(Long id) { this.id = id; }

    @Column(name = "sums")
    public double getSum() { return sum; }
    public void setSum(double sum) { this.sum = sum; }

    @OneToOne
    @JoinColumn(name = "userId")
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    @OneToOne
    public Cart getCart() { return cart; }
    public void setCart(Cart cart) { this.cart = cart; }

    @OneToMany
    public List<Product> getProductList() { return productList; }
    public void setProductList(List<Product> productList) { this.productList = productList; }

    public Invoices(Long id, List<Product> productList, Order order, Delivery delivery, double sum, User user) {
        this.id = id;
        this.productList = cart.getProducts();
        this.order = order.getFulfillment();
        this.delivery = delivery.getValue();
        this.sum = cart.getSum();
        this.user = getUser();
    }

}
