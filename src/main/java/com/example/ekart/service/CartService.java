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
    System.out.println("GetItem###########"+userId);
    return cartRepository.findAllByUserId(userId);
  }

  public List<CartItem> addProductsToCart(AddProductRequest addProductRequest) {
    Product product = Product.builder()
        .productId(addProductRequest.productId)
        .productName(addProductRequest.productName)
        .price(addProductRequest.getPrice())
        .description(addProductRequest.description).build();
    User user = User.builder().userId(addProductRequest.getUserId()).name(addProductRequest.name).build();
    CartItem cartItem = CartItem.builder().
        product(product).quantity(addProductRequest.quantity).user(user).build();
    System.out.println("Saved Item##########"+user.getUserId());

    cartRepository.save(cartItem);
    return cartRepository.findAll();
  }
}
