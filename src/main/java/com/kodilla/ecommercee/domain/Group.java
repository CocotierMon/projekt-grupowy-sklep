package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "GROUPS")
public class Group {

    private Long id;
    private String groupName;
    private List<Product> productsList = new ArrayList<>();

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "group_id", unique = true)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "group_name")
    public void setGroupName(String groupName) { this.groupName = groupName; }

    @OneToMany(
            targetEntity = Product.class,
            mappedBy= "groupId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    public List<Product> getProductsList() { return productsList; }
    public void setProductsList(List<Product> productsList) { this.productsList = productsList; }

    public Group(String groupName) {
        this.groupName=groupName;
    }
}