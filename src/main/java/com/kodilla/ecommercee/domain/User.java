package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "USERS")
public class User {

    private Long id;
    private String username;
    private int status = 1;
    private Long userKey;
    private Cart cart;
    private List<Order> orders = new ArrayList<>();
    private List<Invoice> invoices = new ArrayList<>();

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    @Column(name = "STATUS")
    public int getStatus() {
        return status;
    }

    @Column(name = "USER_KEY")
    public Long getUserKey() {
        return userKey;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CART", referencedColumnName = "ID")
    public Cart getCart() {
        return cart;
    }

    @OneToMany(targetEntity = Order.class, mappedBy = "user", fetch = FetchType.LAZY)
    public List<Order> getOrders() {
        return orders;
    }

    @OneToMany(targetEntity = Invoice.class, mappedBy = "user", fetch = FetchType.LAZY)
    @Column(name = "INVOICES")
    public List<Invoice> getInvoices() {
        return invoices;
    }

}