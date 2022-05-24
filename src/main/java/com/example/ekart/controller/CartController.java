package com.example.ekart.controller;

import com.example.ekart.model.CartItem;
import com.example.ekart.model.Product;
import com.example.ekart.service.AddProductRequest;
import com.example.ekart.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;

public class CartController {

  @Autowired
  ICartService cartService;

  public List<CartItem> getCartItemsForUser(String userId) {
    return cartService.getAllProductsOfCart(userId);
  }

  public HttpStatus addProductToCart(AddProductRequest addProductRequest) {
    cartService.addProductsToCart(addProductRequest);
    return HttpStatus.ACCEPTED;
  }
}
