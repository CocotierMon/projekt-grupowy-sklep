package com.kodilla.ecommercee.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Setter
@Entity
@Table(name = "INVOICES")
public class Invoice {

    private Long id;
    private Cart cart;
    private double sum;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    @Column(name = "SUM")
    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @OneToOne
    @JoinColumn(name = "CART", referencedColumnName = "ID")
    public Cart getCart() {
        return cart;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public Invoice(Cart cart, double sum, User user) {
        this.cart = cart;
        this.sum = sum;
        this.user = user;
    }
}