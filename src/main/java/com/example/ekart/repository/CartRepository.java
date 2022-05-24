package com.example.ekart.repository;

import com.example.ekart.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Product, String> {

}
