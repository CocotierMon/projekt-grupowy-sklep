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
@Entity(name = "USERS")
public class User {

    private Long id;
    private String username;
    private int status;
    private int userKey;
    private Order orderId;
    private Invoices invoice;

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID")
    public Long getId(){
        return id;
    }
    public void setId(Long id) { this.id = id; }

    @Column(name = "USERNAME")
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @Column(name = "STATUS")
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    @Column(name = "USER_KEY")
    public int getUserKey() { return userKey; }
    public void setUserKey(int userKey) { this.userKey = userKey; }

    @OneToOne(cascade = CascadeType.ALL, fetch =FetchType.EAGER)
    @JoinColumn(name="ORDER_ID")
    public Order getOrderId() { return orderId; }
    public void setOrderId(Order orderId) { this.orderId = orderId; }

    @OneToOne
    @JoinColumn(name = "INVOICE_ID")
    public Invoices getInvoice() { return invoice; }
    public void setInvoice(Invoices invoice) { this.invoice = invoice; }

    public User(Long id, String username, int status, int userKey) {
        this.id = id;
        this.username = username;
        this.status = status;
        this.userKey = userKey;
    }
}