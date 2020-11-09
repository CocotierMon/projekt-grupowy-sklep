package com.kodilla.ecommercee.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Setter
@NoArgsConstructor
@Entity
@Table(name = "INVOICES")
public class Invoice {

    private Long id;
    private Order order;

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    public Order getOrder() {
        return order;
    }
}
