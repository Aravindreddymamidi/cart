package com.example.ekart.service;

import com.example.ekart.model.CartItem;
import com.example.ekart.model.Product;
import com.example.ekart.model.User;
import com.example.ekart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

  @Autowired
  CartRepository cartRepository;

  public List<CartItem> getAllProductsOfCart(String userId) {
    Product product = new Product("1000", "Book", 100.0, "XP");
    CartItem cartItem = new CartItem("1511","1001", product, 2);
    cartRepository.save(cartItem);

    System.out.println("GetItem###########"+userId);
    return cartRepository.findAllByUserId(userId);
  }

  public List<CartItem> addProductsToCart(AddProductRequest addProductRequest) {
    Product product = Product.builder()
        .productId(addProductRequest.productId)
        .productName(addProductRequest.productName)
        .price(addProductRequest.getPrice())
        .description(addProductRequest.description).build();
    CartItem cartItem = CartItem.builder().
        product(product).quantity(addProductRequest.quantity).userId(addProductRequest.getUserId()).build();
    System.out.println("Save Item##########"+addProductRequest.getUserId());
    System.out.println("Saved Item##########"+cartItem);

    cartRepository.save(cartItem);
    return cartRepository.findAll();
  }
}
