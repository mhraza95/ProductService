package com.example.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Category extends BaseModel {

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    private List<Product> products;
}
