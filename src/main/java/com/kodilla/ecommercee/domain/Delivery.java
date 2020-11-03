package com.kodilla.ecommercee.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "deliverys")
public class Delivery {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "id", nullable = true)
    private Long id;

    @Column(name = "cost_of_delivery")
    private BigDecimal cost_of_delivery = new BigDecimal(0);

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;
}
