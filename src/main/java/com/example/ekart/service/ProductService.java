package com.example.ekart.service;

import com.example.ekart.model.Product;
import com.example.ekart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  @Autowired
  ProductRepository productRepository;

  public void saveProducts() {
    Product product = new Product("1000", "Book", 100.0, "KentBeck");
    Product product1 = new Product("1001", "PEN", 15.0, "renolds");
    Product product2 = new Product("1002", "RUBBER", 10.0, "Eraser");

    productRepository.save(product);
    productRepository.save(product1);
    productRepository.save(product2);
  }

  public List<Product> getAllProducts() {
    saveProducts();
    return productRepository.findAll();
  }
}
