package com.example.ekart;

import com.example.ekart.controller.ProductController;
import com.example.ekart.model.Product;
import com.example.ekart.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

  @Mock
  ProductService productService;
  @InjectMocks
  ProductController productController;

  @Test
  void shouldGetAllProducts() {
    Product product = new Product("1000", "Book", 100.0, "KentBeck");
    List<Product> productList = new ArrayList<>();
    productList.add(product);

    when(productService.getAllProducts()).thenReturn(productList);

    assertEquals(productController.getAllProducts(),productList);
  }
}
