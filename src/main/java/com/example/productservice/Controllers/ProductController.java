package com.example.productservice.Controllers;

import com.example.productservice.Services.ProductService;
import com.example.productservice.exception.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.security.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private AuthenticationService authenticationService;

    @Autowired
    public ProductController(@Qualifier("realProductService") ProductService productService) {

        this.productService = productService;
    }

    @PostMapping("")
    public Product addProduct(@RequestBody Product product) {

        return productService.addProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable int id) throws ProductNotFoundException {

        return productService.updateProductById(product, id);
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) throws ProductNotFoundException, AccessDeniedException {

//        if(!authenticationService.authenticate(token)) {
//
//            throw new AccessDeniedException("you are not authorized to access this resource");
//        }

        return productService.getProductById(id);
    }

    @GetMapping()
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    @GetMapping("/limit/")
    public List<Product> getLimitedProducts(@RequestParam("limit")  int limit) {

        return productService.getLimitedProducts(limit);
    }

    @DeleteMapping("/{id}")
    public Product deleteProductById(@PathVariable("id") Long id) throws ProductNotFoundException {

        return productService.deleteProductById(id);
    }
}
