package com.example.ekart.controller;

import com.example.ekart.model.CartItem;
import com.example.ekart.service.AddProductRequest;
import com.example.ekart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CartItemController {

  @Autowired
  CartService cartService;

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/get-items/{userId}")
  public List<CartItem> getCartItemsForUser(@PathVariable("userId") String userId) {
    return cartService.getAllProductsOfCart(userId);
  }

  @PostMapping("/add-to-cart")
  public List<CartItem> addProductToCart(@RequestBody AddProductRequest addProductRequest) {
    return cartService.addProductsToCart(addProductRequest);
  }
}
