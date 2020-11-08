package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    private Long sum = 0L;
    private List<Order> orders = new ArrayList<>();

    public Cart(Long sum, List<Order> orders) {
        this.sum = sum;
        this.orders = orders;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name="SUM")
    public Long getSum() {
        return sum;
    }

    @OneToMany(targetEntity = Order.class, mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Order> getOrders() {
        return orders;
    }

}