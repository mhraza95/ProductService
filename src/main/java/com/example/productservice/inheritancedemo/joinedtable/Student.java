package com.example.productservice.inheritancedemo.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "tjt_student")
@Getter
@Setter
public class Student extends User {

    private int psp;
    private String batch;
}
