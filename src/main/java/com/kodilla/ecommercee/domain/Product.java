package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Group group;
}
