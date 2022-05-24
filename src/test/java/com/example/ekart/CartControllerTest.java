package com.example.ekart;

import com.example.ekart.controller.CartController;
import com.example.ekart.model.Product;
import com.example.ekart.service.ICartService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CartControllerTest {

  @InjectMocks
  CartController cartController;
  @Mock
  ICartService cartService;

  @Test
  void shouldGetAllProducts() {
    Product product = new Product(1000, "Book", 100.0, "XP");
    ArrayList<Product> expected = new ArrayList<>();
    expected.add(product);

    when(cartService.getAllProducts()).thenReturn(expected);

    assertThat(expected).isEqualTo(cartController.getAllProducts());
  }
}
