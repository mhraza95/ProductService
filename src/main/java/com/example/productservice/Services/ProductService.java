package com.example.productservice.Services;

import com.example.productservice.models.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id);

    List<Product> getAllProducts();

    void deleteProductById();

    void addProduct();

    void updateProductById();
}
