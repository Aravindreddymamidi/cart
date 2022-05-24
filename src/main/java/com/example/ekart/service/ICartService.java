package com.example.ekart.service;

import com.example.ekart.model.CartItem;

import java.util.List;

public interface ICartService {

  List<CartItem> getAllProductsOfCart(String userId);

  void addProductsToCart(AddProductRequest addProductRequest);
}
