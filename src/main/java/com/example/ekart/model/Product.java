package com.example.ekart.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Product {
  String productId;
  String productName;
  Double price;
  String description;
}
