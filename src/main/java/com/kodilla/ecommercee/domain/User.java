package com.kodilla.ecommercee.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Setter
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {
    private Long id;
    private List<Order> orders = new ArrayList<>();
    private List<Invoice> invoices = new ArrayList<>();
    private Cart cart;
    private int status;
    private Long userKey;
    private String username;
    private String postcode;
    private String town;
    private String street;
    private int houseNumber;
    private int apartmentNumber;

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }
    @OneToMany(targetEntity = Order.class, mappedBy = "user",  fetch = FetchType.LAZY, orphanRemoval = true)
    public List<Order> getOrders() {
        return orders;
    }
    @OneToOne(  fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    public Cart getCart() {
        return cart;
    }
    @OneToMany(targetEntity = Invoice.class, mappedBy = "user",  fetch = FetchType.LAZY, orphanRemoval = true)
    public List<Invoice> getInvoices() {
        return invoices;
    }
    @Column(name="STATUS")
    public int getStatus() {
        return status;
    }
    @Column(name="USER_KEY")
    public Long getUserKey() {
        return userKey;
    }
    @Column(name="USERNAME")
    public String getUsername() {
        return username;
    }
    @Column(name="POSTCODE")
    public String getPostcode() {
        return postcode;
    }
    @Column(name="TOWN")
    public String getTown() {
        return town;
    }
    @Column(name="STREET")
    public String getStreet() {
        return street;
    }
    @Column(name="HOUSE_NUMBER")
    public int getHouseNumber() {
        return houseNumber;
    }
    @Column(name="APARTMENT_NUMBER")
    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public User(String username) {
        this.username = username;
    }
}
