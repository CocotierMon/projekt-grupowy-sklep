package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "INVOICES")
public class Invoices {

    private Long id;
    private User user;
    private Order order;

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID")
    public Long getId() { return id; }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USERS")
    public User getUser() { return user; }

    @ManyToOne(cascade = CascadeType.ALL)
    public Order getOrder() { return order; }

    public Invoices(User user, Order order) {
        this.user = user;
        this.order = order;
    }

}
