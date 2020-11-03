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
public class Invoice {

    private Long id;
    private List<Product> productList = new ArrayList<>();
    private LocalDate order;
    private double delivery;
    private Cart cart;
    private double sum;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "id")
    public Long getId(){ return id; }
    public void setId(Long id) { this.id = id; }

    @Column(name = "sum")
    public double getSum() { return sum; }
    public void setSum(double sum) { this.sum = sum; }

    @OneToOne
    @JoinColumn(name = "user")
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    @OneToOne
    public Cart getCart() { return cart; }
    public void setCart(Cart cart) { this.cart = cart; }

    @OneToMany
    public List<Product> getProductList() { return productList; }
    public void setProductList(List<Product> productList) { this.productList = productList; }

    public Invoice(Long id, List<Product> productList, Order order, Delivery delivery, double sum, User user) {
        this.id = id;
        this.productList = cart.getProducts();
        this.order = order.getFulfillment();
        this.delivery = delivery.getValue();
        this.sum = cart.getSum();
        this.user = getUser();
    }

}
