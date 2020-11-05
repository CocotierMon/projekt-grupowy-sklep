package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="CARTS")
public class Cart {

    private Long id;
    private BigDecimal sum;
    private List<Product> products = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private User user;
    private int amount;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID")
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @Column(name="SUM")
    public BigDecimal getSum() { return sum;}
    public void setSum(BigDecimal sum) { this.sum = sum; }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "JOIN_CART_PRODUCT",
            joinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCTS_ID", referencedColumnName = "ID")})
    public List<Product> getProducts() { return products;}
    public void setProducts(List<Product> products) { this.products = products; }

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    public List<Order> getOrders() { return orders; }
    public void setOrders(List<Order> orders) { this.orders = orders; }

    @OneToOne(cascade = CascadeType.ALL, fetch =FetchType.EAGER)
    @JoinColumn(name="USER_ID")
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    @Column(name = "AMOUNT")
    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

    public Cart(List<Product> products, User user) {
        this.products = products;
        this.user = user;
    }

}