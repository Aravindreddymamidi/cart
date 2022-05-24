package com.example.ekart.service;

import com.example.ekart.model.CartItem;
import com.example.ekart.model.Product;
import com.example.ekart.model.User;
import com.example.ekart.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartService implements ICartService {

  CartRepository cartRepository;


  @Override
  public List<CartItem> getAllProductsOfCart(String userId) {
    System.out.println("################"+userId);
    return cartRepository.findAll(userId);
  }

  @Override
  public void addProductsToCart(AddProductRequest addProductRequest) {
    Product product = Product.builder()
        .productId(addProductRequest.productId)
        .productName(addProductRequest.productName)
        .price(addProductRequest.getPrice())
        .description(addProductRequest.description).build();
    User user = User.builder().userId(addProductRequest.getUserId()).name(addProductRequest.userName).build();
    CartItem cartItem = CartItem.builder().cartItemId(UUID.randomUUID()).
        product(product).quantity(addProductRequest.quantity).user(user).build();

    cartRepository.save(cartItem);
  }
}
