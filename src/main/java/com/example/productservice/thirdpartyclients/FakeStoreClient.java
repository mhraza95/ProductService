package com.example.productservice.thirdpartyclients;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreClient {

    private RestTemplateBuilder restTemplateBuilder;


    private String specificProductUrl = "https://fakestoreapi.com/products/{id}";
    private String genericProductUrl = "https://fakestoreapi.com/products";

    private FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class, id);
        if (responseEntity.getBody() == null) {
            //throw Exception
            throw new ProductNotFoundException("Product not found: " + id);
        }
        return responseEntity.getBody();
    }

    public FakeStoreProductDto[] getAllProducts() {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity(genericProductUrl, FakeStoreProductDto[].class);
        return responseEntity.getBody();
    }
}
