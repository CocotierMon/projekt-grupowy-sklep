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
@Entity(name = "INVOICES")
public class Invoices {

    private Long id;
    private List<Product> productList = new ArrayList<>();
    private LocalDate order;
    private BigDecimal delivery;
    private Cart cart;
    private BigDecimal sum;
    private User user;

    @Column(name = "DATE")
    public LocalDate getOrder() { return order; }
    public void setOrder(LocalDate order) { this.order = order; }

    @Column(name = "DELIVERIES")
    public BigDecimal getDelivery() { return delivery; }
    public void setDelivery(BigDecimal delivery) { this.delivery = delivery; }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    public Long getId(){ return id; }
    public void setId(Long id) { this.id = id; }

    @Column(name = "SUMS")
    public BigDecimal getSum() { return sum; }
    public void setSum(BigDecimal sum) { this.sum = sum; }

    @OneToOne
    @JoinColumn(name = "USER_ID")
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    @OneToOne
    public Cart getCart() { return cart; }
    public void setCart(Cart cart) { this.cart = cart; }

    @OneToMany
    public List<Product> getProductList() { return productList; }
    public void setProductList(List<Product> productList) { this.productList = productList; }

    public Invoices(Long id, List<Product> productList, Order order, Delivery delivery, BigDecimal sum, User user) {
        this.id = id;
        this.productList = cart.getProducts();
        this.order = order.getFulfillment();
        this.delivery = delivery.getValue();
        this.sum = cart.getSum();
        this.user = getUser();
    }

}
