package com.example.productservice.Controllers;

import com.example.productservice.Services.ProductService;
import com.example.productservice.exception.ProductNotFoundException;
import com.example.productservice.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(ProductController.class)
public class ProductControllerMvcTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean(name = "realProductService")
    private ProductService productService;

    @Test
    public void testGetProductById() throws Exception {

        Product dummy = new Product();
        dummy.setId(1L);
        dummy.setTitle("dummy");
        when(productService.getProductById(1L)).thenReturn(dummy);

        mockMvc.perform(get("/products/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L));
    }
}
