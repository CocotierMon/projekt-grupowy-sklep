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
    private Invoices invoice;

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID")
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @Column(name = "VALUE")
    public BigDecimal getValue() { return value; }
    public void setValue(BigDecimal value) { this.value = value; }

    @Transient
    public Invoices getInvoice() { return invoice; }
    public void setInvoice(Invoices invoice) { this.invoice = invoice; }

    public Delivery(Long id, BigDecimal value) {
        this.id = id;
        this.value = value;
    }
}
