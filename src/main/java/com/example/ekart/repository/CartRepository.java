package com.example.ekart.repository;

import com.example.ekart.model.CartItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends MongoRepository<CartItem, String> {

  List<CartItem> findAllByUserId(String userId);

}
