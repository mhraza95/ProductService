package com.example.productservice.security.services;


import com.example.productservice.security.dtos.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AuthenticationService {

    private RestTemplate restTemplate;

    public AuthenticationService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public boolean authenticate(String token){
        ResponseEntity<User> userResponseEntity = restTemplate.postForEntity(("http://localhost:8080/authenticate" + token), null, User.class);

        if (userResponseEntity.getBody() != null){
            return true;
        }

        return false;
    }
}
