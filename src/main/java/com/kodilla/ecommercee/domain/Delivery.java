package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "DELIVERIES")
public class Delivery {

    private Long id;
    private BigDecimal value;
    private Order order;

    public Delivery(BigDecimal value) {
        this.value = value;
    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    public Long getId() {
        return id;
    }

    @Column(name = "DELIVERY_VALUE")
    public BigDecimal getValue() {
        return value;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch =FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
