package com.tdf.restaurantrecommand.service.consumer;

import com.tdf.restaurantrecommand.model.dto.FilterType;
import com.tdf.restaurantrecommand.model.entities.CuisineType;
import com.tdf.restaurantrecommand.model.entities.Restaurant;
import com.tdf.restaurantrecommand.service.restaurant.IRestaurantHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderHandlerServiceImpl implements IOrderHandler {

    private final IRestaurantHandler restaurantHandlerServiceImpl;

    @Override
    public Map<String, Object> orderCuisineFromRestaurant(String userId, String restaurantId, CuisineType cuisineType) {
        log.info("Order type {} created for user {} at restaurant {}.", cuisineType, userId, restaurantId);
        String orderId = UUID.randomUUID().toString();

        List<Restaurant> restaurants = restaurantHandlerServiceImpl.getRestaurants(FilterType.ID, restaurantId);
        Restaurant restaurant = restaurants.stream().findFirst().orElseThrow(()->
                new RuntimeException("Restaurant not found")
        );

        if(!cuisineType.equals(restaurant.getCuisineType())){
            throw new RuntimeException("Cuisine " + cuisineType +" not provided by the Restaurant.");
        }

        return generateResponseMap(orderId, userId, restaurant, cuisineType);
    }

    private Map<String, Object> generateResponseMap(String orderId, String userId, Restaurant restaurant, CuisineType cuisineType) {
        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("userId", userId);
        orderMap.put("orderId", orderId);
        orderMap.put("restaurantId", restaurant.getId());
        orderMap.put("costBracket", restaurant.getCostBracket());
        orderMap.put("cuisineType", cuisineType);
        return orderMap;
    }
}
