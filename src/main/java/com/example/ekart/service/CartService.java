package com.example.ekart.service;

import com.example.ekart.model.Product;
import com.example.ekart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartService implements ICartService {

  @Autowired
  CartRepository cartRepository;

  public List<Product> getAllProducts() {
    return cartRepository.findAll();
  }
}
