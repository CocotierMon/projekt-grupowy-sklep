package com.kodilla.ecommercee.domain;

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
@NoArgsConstructor
@Entity
@Table(name = "orders")
@Access(AccessType.FIELD)
public class Order {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "date_of_order")
    private LocalDate date_of_order;

    @Column(name = "date_of_order_acceptance")
    private LocalDate date_of_order_acceptance;

    @Column(name = "date_of_order_fulfillment")
    private LocalDate fulfillment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToOne(cascade = CascadeType.ALL, fetch =FetchType.EAGER)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "orderId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Product> products;

    public Order(Cart cart){
        this.date_of_order = LocalDate.now();
        this.cart = cart;
        this.products = new ArrayList<>();
    }
}
