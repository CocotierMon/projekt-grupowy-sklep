package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "DELIVERIES")
public class Delivery {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @Column(name = "DELIVERY_VALUE")
    private Long value;

    @OneToOne(cascade = CascadeType.ALL, fetch =FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;




}
