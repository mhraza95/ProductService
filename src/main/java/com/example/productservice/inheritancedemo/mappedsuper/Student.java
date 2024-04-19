package com.example.productservice.inheritancedemo.mappedsuper;

import jakarta.persistence.Entity;

@Entity
public class Student extends User{

    private int psp;
    private String batch;
}
