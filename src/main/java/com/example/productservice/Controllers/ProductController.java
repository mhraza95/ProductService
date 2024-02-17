package com.example.productservice.Controllers;

import com.example.productservice.Services.ProductService;
import com.example.productservice.exception.ProductNotFoundException;
import com.example.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(@Qualifier("FakeProductService") ProductService productService) {

        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {

        return productService.getProductById(id);
    }

    @GetMapping()
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }
}
