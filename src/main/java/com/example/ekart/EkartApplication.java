package com.example.ekart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories("com.example.ekart.repository")
public class EkartApplication {

  public static void main(String[] args) {
    SpringApplication.run(EkartApplication.class, args);
  }
}
