package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
@Table(name = "CARTS")
public class Cart {

    private Long id;
    private BigDecimal sum = new BigDecimal(0);
    private List<Product> products = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "SUM")
    public BigDecimal getSum() {
        return sum;
    }

    @ManyToMany
    @JoinTable(name = "JOIN_CART_PRODUCT",
            joinColumns = {@JoinColumn(name = "CARD_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")})

    public List<Product> getProducts() { return products; }

    @OneToMany(targetEntity = Order.class, mappedBy = "cart", fetch = FetchType.LAZY)
    public List<Order> getOrders() {
        return orders;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void addProduct(Product product, int amount) {
        if (amount > 0) {
            for (int i = 0; i < amount; i++) {
                products.add(product);
                sum = sum.add(product.getPrice());
                product.setAmount(amount);
                product.setSum(product.getPrice().multiply(BigDecimal.valueOf(amount)));
            }
        }
    }

}