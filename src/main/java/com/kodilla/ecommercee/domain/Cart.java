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
@Table(name="CARTS")
public class Cart {

    private Long id;
    private BigDecimal sum = new BigDecimal(0);
    private List<Product> products = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private User user;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() { return id; }

    @Column(name="SUM")
    public BigDecimal getSum() { return sum; }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "JOIN_CART_PRODUCT",
            joinColumns = {@JoinColumn(name = "CARD_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")})
    public List<Product> getProducts() { return products; }

    @OneToMany(targetEntity = Order.class, mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Order> getOrders() { return orders; }

    @OneToOne(cascade = CascadeType.ALL, fetch =FetchType.EAGER)
    @JoinColumn(name="USER_ID")
    public User getUser() { return user; }

    public void addProduct(Product product, int amount){
        if(amount>0){
            for(int i=0; i<amount; i++){
                products.add(product);
                sum = sum.add(product.getPrice());
                product.setAmount(amount);
            }
        }
    }
}