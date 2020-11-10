package com.kodilla.ecommercee.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Setter
@Entity
@Table(name = "USERS")
public class User {
    private Long id;
    private String name;

    public User(String name) {
        this.name = name; 
    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", nullable = true)
    public Long getId(){
        return id;
    }

    @Column(name="NAME")
    public String getName() {
        return name;
    }
}

