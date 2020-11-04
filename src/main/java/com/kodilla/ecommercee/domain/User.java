package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    public User(String username) {
        this.username = username;
    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "id", nullable = true)
    public Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Cart", referencedColumnName = "id")
    public Cart cart;

    @Column(name="status")
    private Long status;

    @Column(name="user_key")
    private Long userKey;

    @Column(name = "username")
    public String username;

    @Column(name = "postcode")
    public String postcode;

    @Column(name = "town")
    public String town;

    @Column(name = "street")
    public String street;

    @Column(name = "house_number")
    public Long houseNumber;

    @Column(name = "apartment_number")
    public Long apartmentNumber;
}