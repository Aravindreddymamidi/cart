package com.example.ekart.repository;

import com.example.ekart.model.CartItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends MongoRepository<CartItem, String> {

  @Query("{userId:'?0'}")
  List<CartItem> findAllByUserId(String userId); // this is called Method Proxy, where we use the right MethodName i.e., "FindAll" and we use ByUserId as an extension to the method.
}
