package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "ADM_GROUP")
public class Group {

    private Long id;
    private String groupName;
    private List<Product> productsList = new ArrayList<>();

    public Group(String groupName) {
        this.groupName = groupName;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "GROUP_ID", unique = true)
    public Long getId() { return id; }

    @Column(name = "GROUP_NAME")
    public String getGroupName() { return groupName; }

    @OneToMany(
            targetEntity = Product.class,
            mappedBy= "groupId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Product> getProductsList() { return productsList; }
}