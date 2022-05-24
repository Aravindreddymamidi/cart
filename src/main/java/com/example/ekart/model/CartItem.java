package com.example.ekart.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class CartItem {
  UUID cartItemId;
  User user;
  Product product;
  int quantity;
}
