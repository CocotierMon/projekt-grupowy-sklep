package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    private Long sum = 0L;
    private List<Product> products = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private User user;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id", unique = true)
    public Long getId() { return id; }

    @Column(name="sum")
    public Long getSum() { return sum;}

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "join_cart_product",
            joinColumns = {@JoinColumn(name = "cart_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")})
    @Column(name="products")
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
    @JoinColumn(name="user_id")
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}