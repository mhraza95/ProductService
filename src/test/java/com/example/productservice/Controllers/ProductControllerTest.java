package com.example.productservice.Controllers;

import com.example.productservice.Services.ProductService;
import com.example.productservice.exception.ProductNotFoundException;
import com.example.productservice.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.nio.file.AccessDeniedException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    @Test
    void getProductById() throws ProductNotFoundException, AccessDeniedException {

        Product dummy = new Product();
        dummy.setId(1L);
        dummy.setTitle("dummy");
        when(productService.getProductById(1L)).thenReturn(dummy);

        Product p = productController.getProductById(1L);
        assertEquals(1L, p.getId());
    }
    @Test
    void getProductByIdThrowsException() throws ProductNotFoundException {


        when(productService.getProductById(1L)).thenThrow(new ProductNotFoundException("Product not found"));


        assertThrows(ProductNotFoundException.class, ()-> productController.getProductById(1L));
    }
}