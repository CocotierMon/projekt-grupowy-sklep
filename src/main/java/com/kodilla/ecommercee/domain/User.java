package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "USERS")
public class User {

    private Long id;
    private String username;
    private int status;
    private int userKey;
    private String postcode;
    private String town;
    private String street;
    private Long houseNumber;
    private Long apartmentNumber;
    private Cart cart;
    private List<Order> orders;
    private List<Invoices> invoice;

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID")
    public Long getId(){
        return id;
    }

    @Column(name = "USERNAME")
    public String getUsername() { return username; }

    @Column(name = "STATUS")
    public int getStatus() { return status; }

    @Column(name = "USER_KEY")
    public int getUserKey() { return userKey; }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CART", referencedColumnName = "ID")
    public Cart getCart(){ return cart; }

    @OneToMany(targetEntity = Order.class, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Order> getOrders() { return orders; }

    @OneToMany(targetEntity = Invoices.class, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name = "INVOICES")
    public List<Invoices> getInvoice() { return invoice; }

    @Column(name = "POSTCODE")
    public String getPostcode() { return postcode; }

    @Column(name = "TOWN")
    public String getTown() { return town; }

    @Column(name = "STREET")
    public String getStreet() { return street; }

    @Column(name = "HOUSE_NUMBER")
    public Long getHouseNumber() { return houseNumber; }

    @Column(name = "APARTMENT_NUMBER")
    public Long getApartmentNumber() { return apartmentNumber; }

    public User(String username, int status, int userKey) {
        this.username = username;
        this.status = status;
        this.userKey = userKey;
    }

    public User(String username) {
        this.username = username;
    }
}