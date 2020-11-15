package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "DELIVERIES")
public class Delivery {

    private Long id;
    private BigDecimal value;
    private Order order;

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID")
    public Long getId() { return id; }

    @Column(name = "VALUE")
    public BigDecimal getValue() { return value; }

    @OneToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    public Order getOrder() { return order; }

    public Delivery(BigDecimal value) {
        this.value = value;
    }

}