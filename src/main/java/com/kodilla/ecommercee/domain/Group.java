package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "GROUPS")
public class Group {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "GROUP_ID", unique = true)
    private Long id;

    @Column(name = "GROUP_NAME")
    private String groupName;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy= "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )

    private List<Product> productsList = new ArrayList<>();

    public Group(String groupName) {
        this.groupName=groupName;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }
}
