package com.example.ekart;

import com.example.ekart.model.Product;
import com.example.ekart.repository.ProductRepository;
import com.example.ekart.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

  @Mock
  ProductRepository productRepository;
  @InjectMocks
  ProductService productService;

  @Test
  void shouldGetAllProductsInDB() {
    Product product = new Product("1000", "Book", 100.0, "KentBeck");
    List<Product> productList = new ArrayList<>();
    productList.add(product);

    when(productRepository.findAll()).thenReturn(productList);

    assertEquals(productList, productService.getAllProducts());
  }
}