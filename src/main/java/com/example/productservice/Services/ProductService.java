package com.example.productservice.Services;

import com.example.productservice.exception.ProductNotFoundException;
import com.example.productservice.models.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id) throws ProductNotFoundException;

    List<Product> getAllProducts();

    void deleteProductById();

    void addProduct();

    void updateProductById();
}
