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
@Entity(name = "DELIVERYS")
public class Delivery {

    private Long id;
    private double value;
    @Transient
    private Invoice invoice;

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "id")
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @Column(name = "value")
    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }

    @Transient
    public Invoice getInvoice() { return invoice; }
    public void setInvoice(Invoice invoice) { this.invoice = invoice; }

    public Delivery(Long id, double value) {
        this.id = id;
        this.value = value;
    }
}
