package com.example.ekart.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
  int id;
  String name;
  Double price;
  String description;
}
