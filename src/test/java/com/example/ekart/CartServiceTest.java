package com.example.ekart;

import com.example.ekart.model.CartItem;
import com.example.ekart.model.Product;
import com.example.ekart.model.User;
import com.example.ekart.repository.CartRepository;
import com.example.ekart.service.AddProductRequest;
import com.example.ekart.service.CartService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {

  @Mock
  CartRepository cartRepository;
  @InjectMocks
  CartService cartService;
  @Test
  void shouldGetAllProductsInsideCart() {
    String cartItemId = "6098d60f-b9ea-4817-aaae-91a736844951";
    User user = new User("101", "tej");
    Product product = new Product("1000", "Book", 100.0, "XP");
    CartItem cartItem = new CartItem(cartItemId, user, product, 2);
    List<CartItem> expected = new ArrayList<>();
    expected.add(cartItem);

    when(cartRepository.findAllByUserId(user.getUserId())).thenReturn(expected);
    List<CartItem> productsOfCart = cartService.getAllProductsOfCart(user.getUserId());
    assertEquals(expected, productsOfCart);
  }

  @Test
  void shouldSaveProductInCart() {
    User user = new User("101", "tej");
    Product product = new Product("1000", "Book", 100.0, "XP");
    CartItem cartItem = new CartItem(null, user, product, 2);
    AddProductRequest addProductRequest = AddProductRequest.builder().productId("1000")
        .productName("Book")
        .price(100.0)
        .description("XP")
        .userId("101")
        .name("tej")
        .quantity(2).build();

    cartService.addProductsToCart(addProductRequest);

    verify(cartRepository, times(1)).save(cartItem);
  }
}