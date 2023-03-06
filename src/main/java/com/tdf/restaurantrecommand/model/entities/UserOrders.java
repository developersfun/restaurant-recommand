package com.tdf.restaurantrecommand.model.entities;

import com.tdf.restaurantrecommand.model.dto.CuisineType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Entity(name = "user_orders")
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
public class UserOrders {
    @Id
    private String orderId;
    private String userId;
    private String restaurantId;
    @Enumerated(EnumType.STRING)
    private CuisineType cuisineType;
    private Integer costBracket;
    private ZonedDateTime orderDate;
}
