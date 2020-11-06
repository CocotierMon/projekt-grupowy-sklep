package com.kodilla.ecommercee.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Entity
@Table(name = "PRODUCTS")
public class Product {
    private Long id;
    private List<Cart> carts = new ArrayList<>();

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", nullable = true)
    public Long getId(){
        return id;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    public List<Cart> getCarts() { return carts; }

}
