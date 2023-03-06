package com.tdf.restaurantrecommand.controller;

import com.tdf.restaurantrecommand.model.entities.Restaurant;
import com.tdf.restaurantrecommand.service.restaurant.IRestaurantHandler;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles Restaurant addition and alteration activities
 * @since 19
 * @author neeraj
 */
@RestController
@AllArgsConstructor
@RequestMapping("/v1/restaurant")
public class RestaurantHandlerController {
    private final IRestaurantHandler restaurantHandlerServiceImpl;

    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        restaurant = restaurantHandlerServiceImpl.addRestaurant(restaurant);
        return restaurant;
    }
}
