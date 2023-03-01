package com.tdf.restaurantrecommand.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "user_orders")
public class UserOrders {
    @Id
    private String userId;
    private CuisineType cuisineType;
    private Double costBracket;
}
