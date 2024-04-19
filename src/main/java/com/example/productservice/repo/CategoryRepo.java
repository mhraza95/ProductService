package com.example.productservice.repo;

import com.example.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);
}
