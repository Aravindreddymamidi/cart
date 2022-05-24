package com.example.ekart.service;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddProductRequest {
  String userId;
  String userName;
  int productId;
  String productName;
  Double price;
  String description;
  int quantity;
}
