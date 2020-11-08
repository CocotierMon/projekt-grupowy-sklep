package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
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
    private Order orderId;
    private List<Invoices> invoice;

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID")
    public Long getId(){
        return id;
    }
    public void setId(Long id) { this.id = id; }

    @Column(name = "USERNAME")
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @Column(name = "STATUS")
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    @Column(name = "USER_KEY")
    public int getUserKey() { return userKey; }
    public void setUserKey(int userKey) { this.userKey = userKey; }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CART", referencedColumnName = "ID")
    public Cart getCart(){ return cart; }
    public void setCart(Cart cart) { this.cart = cart; }

    @OneToOne(cascade = CascadeType.ALL, fetch =FetchType.LAZY)
    @JoinColumn(name="ORDER_ID")
    public Order getOrderId() { return orderId; }
    public void setOrderId(Order orderId) { this.orderId = orderId; }

    @OneToMany(targetEntity = Invoices.class, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name = "INVOICES")
    public List<Invoices> getInvoice() { return invoice; }
    public void setInvoice(List<Invoices> invoice) { this.invoice = invoice; }

    @Column(name = "POSTCODE")
    public String getPostcode() { return postcode; }
    public void setPostcode(String postcode) { this.postcode = postcode; }

    @Column(name = "TOWN")
    public String getTown() { return town; }
    public void setTown(String town) { this.town = town; }

    @Column(name = "STREET")
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    @Column(name = "HOUSE_NUMBER")
    public Long getHouseNumber() { return houseNumber; }
    public void setHouseNumber(Long houseNumber) { this.houseNumber = houseNumber; }

    @Column(name = "APARTMENT_NUMBER")
    public Long getApartmentNumber() { return apartmentNumber; }
    public void setApartmentNumber(Long apartmentNumber) { this.apartmentNumber = apartmentNumber; }

    public User(String username, int status, int userKey) {
        this.username = username;
        this.status = status;
        this.userKey = userKey;
    }

    public User(String username) {
        this.username = username;
    }
}