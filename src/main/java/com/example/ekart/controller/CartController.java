package com.example.ekart.controller;

import com.example.ekart.model.Product;
import com.example.ekart.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartController {

  @Autowired
  ICartService cartService;

  public List<Product> getAllProducts() {
   return cartService.getAllProducts();
  }
}
