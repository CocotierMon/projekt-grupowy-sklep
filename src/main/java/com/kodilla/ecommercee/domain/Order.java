package com.kodilla.ecommercee.domain;

import lombok.AccessLevel;
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
@Setter(AccessLevel.PRIVATE)
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

    @OneToOne(cascade = CascadeType.ALL, fetch =FetchType.EAGER)
    @JoinColumn(name="invoice_id")
    private Invoice invoice;

    @Transient
    private List<Product> products = new ArrayList<>();

    @Column(name="sum")
    private BigDecimal sum = new BigDecimal(0);

    @Column(name = "total_sum_of_order")
    private BigDecimal total_sum_of_order;

    public Order(Cart cart, Delivery delivery){
        this.date_of_order = LocalDate.now();
        this.cart = cart;

        this.products = cart.getProducts();
        this.sum = cart.getSum();

        this.total_sum_of_order = cart.getSum().add(delivery.getCost_of_delivery());
    }
    public void setProducts(Cart cart){ products = cart.getProducts();
    }
    public void setSum(Cart cart){  sum = cart.getSum();
    }
}
