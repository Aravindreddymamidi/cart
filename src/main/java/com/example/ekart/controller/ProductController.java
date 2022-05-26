package com.example.ekart.controller;

import com.example.ekart.model.Product;
import com.example.ekart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  ProductService productService;

  @GetMapping()
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }
}
