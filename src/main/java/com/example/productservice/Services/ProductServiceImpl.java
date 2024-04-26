package com.example.productservice.Services;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repo.CategoryRepo;
import com.example.productservice.repo.ProductRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Primary
@Service("realProductService")
public class ProductServiceImpl implements ProductService{

    private ProductRepo productRepo;
    private CategoryRepo categoryRepo;

    public ProductServiceImpl(ProductRepo productRepo, CategoryRepo categoryRepo) {

        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }
    @Override
    public Product getProductById(Long id) {

        Optional<Product> product = productRepo.findById(id);
        //Category category = product.get().getCategory();
        return product.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public List<Product> getLimitedProducts(int limit) { return null;}

    @Override
    public Product deleteProductById(Long id) {
        return null;
    }

    @Override
    public Product addProduct(Product product) {

        /*Optional<Category> categoryOptional = this.categoryRepo.findByName(product.getCategory().getName());

        if(categoryOptional.isPresent()) {

            product.setCategory(categoryOptional.get());
        }else {
            Category category = categoryRepo.save(product.getCategory());
            product.setCategory(category);
        }*/
        return this.productRepo.save(product);

    }

    @Override
    public Product updateProductById(Product product, int id)  {

        return null;
    }
}
