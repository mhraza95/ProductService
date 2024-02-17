package com.example.productservice.Services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.exception.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.thirdpartyclients.FakeStoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

@Service("FakeProductService")
public class FakeProductServiceImpl implements ProductService{

    private FakeStoreClient fakeStoreClient;
    private RestTemplateBuilder restTemplateBuilder;
    //private String getProductUrl = "https://fakestoreapi.com/products/1";
    //private String getAllProductUrl = "https://fakestoreapi.com/products";

    @Autowired
    public FakeProductServiceImpl(FakeStoreClient fakeStoreClient) {

        this.fakeStoreClient = fakeStoreClient;
    }
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {

        return getProductFromFakeStoreDto(fakeStoreClient.getProductById(id));
    }

    @Override
    public List<Product> getAllProducts() {

        List<Product> productList = new LinkedList<>();
        for (FakeStoreProductDto fakeStoreProductDto: fakeStoreClient.getAllProducts()) {
            productList.add(getProductFromFakeStoreDto(fakeStoreProductDto));
        }
        return productList;
    }

    @Override
    public void deleteProductById() {

    }

    @Override
    public void addProduct() {

    }

    @Override
    public void updateProductById() {

    }

    private Product getProductFromFakeStoreDto(FakeStoreProductDto fakeStoreProductDto) {

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDesc(fakeStoreProductDto.getDescription());

        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }
}
