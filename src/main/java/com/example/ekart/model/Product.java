package com.example.ekart.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Data
@Builder
public class Product {
  @Id
  int productId;
  String productName;
  Double price;
  String description;
}
