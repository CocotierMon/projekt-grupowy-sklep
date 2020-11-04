package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Entity
@Table(name="carts")
public class Cart {
    private Long id;
    private BigDecimal sum = new BigDecimal(0);
    private List<Product> products = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private User user;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name="sum")
    public BigDecimal getSum() {
        return sum;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "join_cart_product",
            joinColumns = {@JoinColumn(name = "cart_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")})
    @Column(name="products")
    public List<Product> getProducts() {
        return products;
    }

    @OneToMany(targetEntity = Order.class, mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Order> getOrders() {
        return orders;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch =FetchType.EAGER)
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }
}
