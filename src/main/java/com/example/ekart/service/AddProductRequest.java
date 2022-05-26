package com.example.ekart.service;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddProductRequest {
  String userId;
  String productId;
  String productName;
  Double price;
  String description;
  int quantity;
}
