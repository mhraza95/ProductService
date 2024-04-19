package com.example.productservice.Services;

import com.example.productservice.exception.ProductNotFoundException;
import com.example.productservice.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product getProductById(Long id) throws ProductNotFoundException;

    List<Product> getAllProducts();

    List<Product> getLimitedProducts(int limit);

    Product deleteProductById(Long id) throws ProductNotFoundException;

    Product addProduct(Product product);

    Product updateProductById(Product product, int id) throws ProductNotFoundException;
}
