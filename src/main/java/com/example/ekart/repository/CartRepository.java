package com.example.ekart.repository;

import com.example.ekart.model.CartItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CartRepository extends MongoRepository<CartItem, String> {

  @Query("{userId:'?0'}")
  List<CartItem> findAll(String userId);
}
