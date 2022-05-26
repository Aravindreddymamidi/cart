package com.example.ekart.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Builder
@Document
public class CartItem {
  @Id
  String id;
  String userId;
  Product product;
  int quantity;
}
