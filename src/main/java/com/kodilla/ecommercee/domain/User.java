package com.kodilla.ecommercee.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Setter
@Entity
@Table(name = "users")
public class User {
    private Long id;
    private String name;

    public User(String name) {
        this.name = name;

    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "id", nullable = true)
    public Long getId(){
        return id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }
}
