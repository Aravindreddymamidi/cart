package com.example.ekart;

import com.example.ekart.controller.CartItemController;
import com.example.ekart.model.CartItem;
import com.example.ekart.model.Product;
import com.example.ekart.model.User;
import com.example.ekart.service.AddProductRequest;
import com.example.ekart.service.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CartItemControllerTest {

  @InjectMocks
  CartItemController cartItemController;
  @Mock
  CartService cartService;

  User user;
  Product product;
  CartItem cartItem;
  ArrayList<CartItem> expected = new ArrayList<>();

  @BeforeEach
  void setUp() {
    String cartItemId = "6098d60f-b9ea-4817-aaae-91a736844951";
    user = new User("101", "tej");
    product = new Product("1000", "Book", 100.0, "XP");
    cartItem = new CartItem(cartItemId, user, product, 2);
    expected.add(cartItem);
  }

  @Test
  void shouldGetAllProducts() {
    when(cartService.getAllProductsOfCart(user.getUserId())).thenReturn(expected);

    assertThat(expected).isEqualTo(cartItemController.getCartItemsForUser(user.getUserId()));
  }

  @Test
  void shouldAddProductToCart() {
    AddProductRequest addProductRequest = AddProductRequest.builder().
        userId("101")
        .name("tej")
        .productId("1000")
        .description("XP")
        .productName("Book")
        .price(100.0)
        .quantity(2)
        .build();

    when(cartService.addProductsToCart(addProductRequest)).thenReturn(expected);

    assertThat(expected).isEqualTo(cartItemController.addProductToCart(addProductRequest));
  }
}
