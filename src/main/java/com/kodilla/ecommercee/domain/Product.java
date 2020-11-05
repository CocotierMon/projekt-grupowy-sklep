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
@Entity(name = "PRODUCTS")
public class Product {

    private Long id;
    private String name;
    private String description;
    private double price;
    public Group groupId;
    private List<Cart> carts = new ArrayList<>();
    private Invoices invoice;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "id")
    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "product_name")
    @NotNull
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Column(name = "description")
    @NotNull
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Column(name = "price")
    @NotNull
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    public Group getGroupId() { return groupId; }
    public void setGroupId(Group groupId) { this.groupId = groupId; }

    @Transient
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    public List<Cart> getCarts() { return carts; }
    @Transient
    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    @Transient
    @OneToOne(cascade = CascadeType.ALL)
    public Invoices getInvoice() { return invoice; }
    public void setInvoice(Invoices invoice) { this.invoice = invoice; }

    public Product(Long id, String name, String description, double price, Group groupId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.groupId = groupId;
    }

}
