package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "USERS")
public class User {

    private Long id;
    private Long userKey;
    private Long status;
    private String username;
    private String postcode;
    private String town;
    private String street;
    private Long houseNumber;
    private Long apartmentNumber;
    private Cart cart;
    private List<Order> orders = new ArrayList<>();

    public User(String username) {
        this.username = username;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CART", referencedColumnName = "ID")
    public Cart getCart(){
        return cart;
    };

    @OneToMany(targetEntity = Order.class, mappedBy = "USER", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Order> getOrders() {
        return orders;
    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    @Column(name="STATUS")
    public Long getStatus() {
        return status;
    }

    @Column(name="USER_KEY")
    public Long getUserKey() {
        return userKey;
    }
    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }
    @Column(name = "POSTCODE")
    public String getPostcode() {
        return postcode;
    }
    @Column(name = "TOWN")
    public String getTown() {
        return town;
    }
    @Column(name = "STREET")
    public String getStreet() {
        return street;
    }
    @Column(name = "HOUSE_NUMBER")
    public Long getHouseNumber() {
        return houseNumber;
    }
    @Column(name = "APARTMENT_NUMBER")
    public Long getApartmentNumber() {
        return apartmentNumber;
    }
}