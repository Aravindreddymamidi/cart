package com.example.ekart;

import com.example.ekart.model.Product;
import com.example.ekart.repository.CartRepository;
import com.example.ekart.service.ICartService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {

  @Mock
  ICartService cartService;
  @Mock
  CartRepository cartRepository;

  @Test
  void shouldGetAllProductsInsideCart() {
    Product product = new Product(1000, "Book", 100.0, "XP");
    ArrayList<Product> expected = new ArrayList<>();
    expected.add(product);

    when(cartRepository.findAll()).thenReturn(expected);

    assertEquals(expected, cartService.getAllProducts());
  }
}