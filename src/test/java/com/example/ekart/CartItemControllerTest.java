package com.example.ekart;

import com.example.ekart.controller.CartController;
import com.example.ekart.model.CartItem;
import com.example.ekart.model.Product;
import com.example.ekart.model.User;
import com.example.ekart.service.AddProductRequest;
import com.example.ekart.service.ICartService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CartItemControllerTest {

  @InjectMocks
  CartController cartController;
  @Mock
  ICartService cartService;

  @Test
  void shouldGetAllProducts() {
    User user = new User("101", "tej");
    Product product = new Product(1000, "Book", 100.0, "XP");

    CartItem cartItem = new CartItem(UUID.randomUUID(), user, product, 2);
    ArrayList<CartItem> expected = new ArrayList<>();
    expected.add(cartItem);

    when(cartService.getAllProductsOfCart(user.getUserId())).thenReturn(expected);

    assertThat(expected).isEqualTo(cartController.getCartItemsForUser(user.getUserId()));
  }

  @Test
  void shouldAddProductToCart() {
    AddProductRequest addProductRequest = AddProductRequest.builder().
        userId("101")
        .userName("tej")
        .productId(1002)
        .description("GermanMade")
        .productName("Gun")
        .price(100.0)
        .quantity(2)
        .build();

    HttpStatus status = cartController.addProductToCart(addProductRequest);

    assertThat(status).isEqualTo(HttpStatus.ACCEPTED);
  }
}
