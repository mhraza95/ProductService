package com.example.productservice.Services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.exception.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.thirdpartyclients.FakeStoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

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
    public List<Product> getLimitedProducts(int limit) {

        List<Product> productList = new LinkedList<>();
        for (FakeStoreProductDto fakeStoreProductDto: fakeStoreClient.getLimitedProduct(limit)) {

            productList.add(getProductFromFakeStoreDto(fakeStoreProductDto));
        }

        return productList;
    }

    @Override
    public Product deleteProductById(Long id) throws ProductNotFoundException {

        return getProductFromFakeStoreDto(fakeStoreClient.deleteProductById(id));
    }

    @Override
    public Product addProduct(Product product) {

        return getProductFromFakeStoreDto(fakeStoreClient.addProduct(getFakeStoreProductDtoFromProduct(product)));
    }

    private FakeStoreProductDto getFakeStoreProductDtoFromProduct(Product product) {

        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        fakeStoreProductDto.setPrice(product.getPrice());

        return fakeStoreProductDto;
    }

    private Product getProductFromFakeStoreDto(FakeStoreProductDto fakeStoreProductDto) {

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());

        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }

    @Override
    public Product updateProductById(Product product, int id) throws ProductNotFoundException {
        return getProductFromFakeStoreDto(fakeStoreClient.updateProduct(getFakeStoreProductDtoFromProduct(product), id));
    }
}
